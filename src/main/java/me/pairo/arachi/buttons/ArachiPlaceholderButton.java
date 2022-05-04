package me.pairo.arachi.buttons;

import me.pairo.arachi.types.impl.Button;
import me.pairo.arachi.types.impl.Menu;
import me.pairo.arachi.util.Item;
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
    public void clicked(Player player, Menu menu, int slot, ClickType clickType, int hotbarButton) {

    }

}