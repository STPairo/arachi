package me.pairo.arachi.menu;

import me.pairo.arachi.menu.impl.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public interface IButton {

    ItemStack getItem();

    void clicked(Player player, Menu menu, ClickType clickType, ItemStack clickedItem, int hotbarButton, int slot);

}
