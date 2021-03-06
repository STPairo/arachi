package me.pairo.arachi.menu.buttons;

import me.pairo.arachi.menu.impl.Button;
import me.pairo.arachi.menu.impl.Menu;
import me.pairo.arachi.util.item.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class ArachiPlaceholderButton extends Button {

    @Override
    public ItemStack getItem() {
        return new Item(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(" ").setLore("").toItemStack();
    }

    @Override
    public void clicked(Player player, Menu menu, ClickType clickType, ItemStack clickedItem, int hotbarButton, int slot) {

    }

}