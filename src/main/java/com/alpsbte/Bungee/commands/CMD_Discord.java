package com.alpsbte.Bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Discord extends Command {
    public CMD_Discord(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if(sender.hasPermission("alpsbte.discord")) {
                ProxiedPlayer player = (ProxiedPlayer) sender;
                TextComponent message = new TextComponent(new TextComponent(ChatColor.GRAY + "[" + ChatColor.GOLD + "Join the Discord" + ChatColor.GRAY + "] >" + ChatColor.GREEN + " https://discord.gg/vgkspay"));
                message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/vgkspay"));
                player.sendMessage(message);
            }
        }
    }
}
