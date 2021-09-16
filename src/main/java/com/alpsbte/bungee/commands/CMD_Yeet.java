package com.alpsbte.bungee.commands;

import com.alpsbte.bungee.BungeePlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Yeet extends Command {
    public CMD_Yeet(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if(sender.hasPermission("alpsbte.yeet")) {
                ProxiedPlayer p;
                try {
                    if(args.length >= 1) {
                        p = BungeePlugin.getPlugin().getProxy().getPlayer(args[0]);
                    } else {
                        p = (ProxiedPlayer)sender;
                    }

                    p.disconnect(new TextComponent(ChatColor.RED + "You got yeeted from the server!"));
                } catch (Exception ex) {
                    sender.sendMessage(new TextComponent(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + ChatColor.RED + "Usage: /yeet <player>"));
                }
            }
        }
    }
}
