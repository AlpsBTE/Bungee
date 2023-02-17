package com.alpsbte.bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_RemoveBuilder extends Command {
    public CMD_RemoveBuilder(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission("alpsbte.reviewer")) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (args.length == 1) {
                ProxiedPlayer builderPlayer = ProxyServer.getInstance().getPlayer(args[0]);
                if (builderPlayer != null) {
                    ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + builderPlayer.getUniqueId() + " group remove builder");
                    player.sendMessage(new TextComponent(ChatColor.GRAY + ">> " + ChatColor.GREEN + "Removed builder permissions from " + ChatColor.GRAY + builderPlayer.getName() + ChatColor.GREEN + "."));
                } else {
                    player.sendMessage(new TextComponent(ChatColor.GRAY + ">> " + ChatColor.RED + "Could not find builder with Name/UUID " + ChatColor.GRAY + args[0] + ChatColor.RED + "."));
                }
            } else {
                player.sendMessage(new TextComponent(ChatColor.GRAY + ">> " + ChatColor.RED + "Unknown arguments. Use " + ChatColor.GRAY + "/removebuilder <Name/UUID>" + ChatColor.RED + "."));
            }
        }
    }
}
