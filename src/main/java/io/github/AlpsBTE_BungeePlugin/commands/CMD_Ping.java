package github.AlpsBTE_BungeePlugin.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Ping extends Command {
    public CMD_Ping(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if(sender.hasPermission("alpsbte.ping")) {
                ProxiedPlayer player = (ProxiedPlayer) sender;

                int ping = player.getPing();
                player.sendMessage(new TextComponent(ChatColor.GRAY + "[" + ChatColor.GOLD + "Ping" + ChatColor.GRAY + "] > " + ChatColor.GREEN + ping));
            }
        }
    }
}
