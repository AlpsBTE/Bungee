package github.AlpsBTE_BungeePlugin;

import github.AlpsBTE_BungeePlugin.commands.CMD_Discord;
import github.AlpsBTE_BungeePlugin.commands.CMD_Ping;
import github.AlpsBTE_BungeePlugin.commands.CMD_Yeet;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class AlpsBTE_BungeePlugin extends Plugin {

    private static AlpsBTE_BungeePlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Commands
        getProxy().getPluginManager().registerCommand(this, new CMD_Yeet("yeet"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Discord("discord"));
        getProxy().getPluginManager().registerCommand(this, new CMD_Ping("ping"));

        // Listener
        getProxy().getPluginManager().registerListener(this, new EventListener());

        getLogger().log(Level.INFO, "Successfully enabled AlpsBTE-BungeePlugin.");
    }

    public static AlpsBTE_BungeePlugin getPlugin() {
        return plugin;
    }
}
