package com.alpsbte.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class Utils {

    public static TextComponent getErrorFormat(String message) {
        return new TextComponent(ChatColor.GRAY + "> " + ChatColor.RED + message);
    }

}
