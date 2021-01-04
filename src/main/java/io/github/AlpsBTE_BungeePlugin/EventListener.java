package github.AlpsBTE_BungeePlugin;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {

    @EventHandler
    public void PlayerChatEvent(ChatEvent event) {
        if(event.getMessage().contains("ß")) {
            event.setMessage(event.getMessage().replace("ß", "ss").replace("ẞ", "ss"));
        }
    }
}
