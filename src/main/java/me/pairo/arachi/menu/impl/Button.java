package me.pairo.arachi.menu.impl;

import me.pairo.arachi.menu.IButton;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class Button implements IButton {

    public static void playSound(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

}
