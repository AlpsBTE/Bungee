package github.AlpsBTE_BungeePlugin;

import github.AlpsBTE_BungeePlugin.commands.CMD_Discord;
import github.AlpsBTE_BungeePlugin.commands.CMD_Ping;
import github.AlpsBTE_BungeePlugin.commands.CMD_Yeet;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

public class AlpsBTE_BungeePlugin extends Plugin implements Listener {

    private static AlpsBTE_BungeePlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Commands
        getProxy().getPluginManager().registerCommand(this, new CMD_Yeet("yeet"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Discord("discord"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Ping("ping"));


        Thread thread = new Thread(() -> {
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(42069)) {
                    Socket socket = serverSocket.accept();

                    new ChatHandler(socket).start();
                } catch (IOException ex) {
                    getLogger().log(Level.SEVERE, "Could not connect server to BungeeCord!", ex);
                }
            }
        });
        thread.start();

        getLogger().log(Level.INFO, "Successfully enabled AlpsBTE-BungeePlugin!");
    }

    public static AlpsBTE_BungeePlugin getPlugin() {
        return plugin;
    }
}
