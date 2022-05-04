package me.pairo.arachi.util;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colorizer {

    private String text;

    private final Pattern PATTERN_HEX = Pattern.compile("#[0-9a-fA-F]{6}");

    public Colorizer(String text) {
        this.text = text;
    }

    public Colorizer() {
        this("");
    }

    public Colorizer colorizeBukkit(char symbol) {
        this.text = ChatColor.translateAlternateColorCodes(symbol, this.text);
        return this;
    }

    public Colorizer colorizeCustom() {
        Matcher matcher = PATTERN_HEX.matcher(this.text);
        while (matcher.find()) {
            String color = this.text.substring(matcher.start(), matcher.end());
            this.text = this.text.replace(color, ChatColor.of(color) + "");
            matcher = PATTERN_HEX.matcher(this.text);
        }
        return this;
    }

    public String colorize(char symbol) {
        colorizeCustom();
        colorizeBukkit(symbol);

        return this.text;
    }

    public String toString() {
        return this.text == null ? "" : this.text;
    }

}
