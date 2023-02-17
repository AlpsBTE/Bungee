package com.alpsbte.bungee.commands;

import com.alpsbte.bungee.Server;
import com.alpsbte.bungee.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Switch extends Command {
    public CMD_Switch(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            if (sender.hasPermission("alpsbte.switch")) {
                ProxiedPlayer player = (ProxiedPlayer) sender;

                Server server;
                if (args.length > 0) {
                    try {
                        server = Server.valueOf(args[0].toUpperCase());
                    } catch (IllegalArgumentException ex) {
                        player.sendMessage(Utils.getErrorFormat("This server does not exist!"));
                    }
                }
            }
        }
    }
}
