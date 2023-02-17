package com.alpsbte.bungee.commands;

import com.alpsbte.bungee.BungeePlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CMD_ReJoin extends Command implements Listener {

    public CMD_ReJoin(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    public static HashMap<ProxiedPlayer, String> connectingPlayers = new HashMap<>();

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (!player.getServer().getInfo().getName().equals("ALPS-1")) {
                String lastServer = player.getServer().getInfo().getName();
                //connectingPlayers.put(player,lastServer);

                player.connect(BungeePlugin.getPlugin().getProxy().getServerInfo("ALPS-1"));

                //AAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHH
                //I want to die
                BungeePlugin.getPlugin().getProxy().getScheduler().schedule(BungeePlugin.getPlugin(), () -> player.connect(BungeePlugin.getPlugin().getProxy().getServerInfo(lastServer)), 2, TimeUnit.SECONDS);
            } else {
                player.sendMessage(new TextComponent(ChatColor.RED + "You are currently connected to the HUB Server! Make sure you are connected to a Subserver."));
            }
        }
    }
}
