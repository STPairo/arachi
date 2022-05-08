package me.pairo.arachi.buttons;

import me.pairo.arachi.Arachi;
import me.pairo.arachi.types.impl.Button;
import me.pairo.arachi.types.impl.Menu;
import me.pairo.arachi.util.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class ArachiExitButton extends Button {

    @Override
    public ItemStack getItem() {
        return new Item(Material.BARRIER).setName("&c&lExit menu").setLore("", "&7Click to exit").toItemStack();
    }

    @Override
    public void clicked(Player player, Menu menu, ClickType clickType, ItemStack clickedItem, int hotbarButton, int slot) {
        Menu openMenu = Arachi.OPEN_MENUS.get(player.getUniqueId());
        openMenu.setPersistent(false);
        openMenu.close(player);
    }

}