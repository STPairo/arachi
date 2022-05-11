package me.pairo.arachi.util;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    private static final Pattern PATTERN_HEX = Pattern.compile("#[0-9a-fA-F]{6}");

    private static String colorizeBukkit(String message, char symbol) {
        message = ChatColor.translateAlternateColorCodes(symbol, message);
        return message;
    }

    private static String colorizeCustom(String message) {
        Matcher matcher = PATTERN_HEX.matcher(message);
        while (matcher.find()) {
            String color = message.substring(matcher.start(), matcher.end());
            message = message.replace(color, ChatColor.of(color) + "");
            matcher = PATTERN_HEX.matcher(message);
        }
        return message;
    }
    
    public static String fmt(String message) {
        message = colorizeBukkit(message, '&');
        message = colorizeCustom(message);
        return message;
    }
    
}
