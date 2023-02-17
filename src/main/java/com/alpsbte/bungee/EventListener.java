package com.alpsbte.bungee;

import com.alpsbte.bungee.commands.CMD_ReJoin;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {

    @EventHandler
    public void onServerConnected(ServerConnectedEvent event) {
        if (CMD_ReJoin.connectingPlayers.containsKey(event.getPlayer())) {
            //event.getPlayer().connect(BungeePlugin.getPlugin().getProxy().getServerInfo(CMD_ReJoin.connectingPlayers.get(event.getPlayer())));
            //CMD_ReJoin.connectingPlayers.remove(event.getPlayer());
        }
    }
}
