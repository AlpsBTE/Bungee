package com.alpsbte.bungee;

import com.alpsbte.bungee.commands.CMD_Discord;
import com.alpsbte.bungee.commands.CMD_Ping;
import com.alpsbte.bungee.commands.CMD_ReJoin;
import com.alpsbte.bungee.commands.CMD_Yeet;
import com.alpsbte.bungee.commands.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

public class BungeePlugin extends Plugin implements Listener {

    private static BungeePlugin plugin;
    private static ServerSocket serverSocket;

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void onEnable() {
        plugin = this;

        getProxy().getPluginManager().registerCommand(this, new CMD_Yeet("yeet"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Discord("discord"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Ping("ping"));
        getProxy().getPluginManager().registerCommand(this, new CMD_AddBuilder("addbuilder"));
        getProxy().getPluginManager().registerCommand(this, new CMD_RemoveBuilder("removebuilder"));
        getProxy().getPluginManager().registerCommand(this,new CMD_ReJoin("re", "alpsbte.rejoin", "rejoin"));

        getProxy().getPluginManager().registerListener(this, new EventListener());

        CompletableFuture.runAsync(() -> {
            try {
                serverSocket = new ServerSocket(42069);
                while (true) new ChatHandler(serverSocket.accept()).start();
            } catch (IOException ex) {
                if (serverSocket == null) getLogger().log(Level.SEVERE, "Could not bind port to socket!", ex);
            }
        });

        getLogger().log(Level.INFO, "Successfully enabled AlpsBTE-Bungee!");
    }

    @Override
    public void onDisable() {
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                getLogger().log(Level.SEVERE, "Could not unbind port from socket!", ex);
            }
        }
    }

    public static BungeePlugin getPlugin() {
        return plugin;
    }
}
