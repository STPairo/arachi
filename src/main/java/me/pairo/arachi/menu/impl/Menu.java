package me.pairo.arachi.menu.impl;

import me.pairo.arachi.Arachi;
import me.pairo.arachi.menu.buttons.ArachiPlaceholderButton;
import me.pairo.arachi.menu.IMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public abstract class Menu implements IMenu {
    private boolean allowsPlaceholders = true;
    private Button placeholderButton = new ArachiPlaceholderButton();

    public void open(Player player) {
        // Title must be 32 characters or less.
        String title = this.getTitle().substring(0, Math.min(this.getTitle().length(), 32));
        // Size is given by the calculation based on the highest button key.
        int size = this.getSize(this.getMenuButtons());

        Menu previousMenu = Arachi.OPEN_MENUS.get(player.getUniqueId());
        if (previousMenu != null) previousMenu.close(player);
        Arachi.OPEN_MENUS.remove(player.getUniqueId());

        Inventory inventory = Bukkit.createInventory(player, size, title);
        player.closeInventory();

        inventory.setContents(new ItemStack[size]);

        // Fill the inventory with the buttons and the placeholders.
        this.addAllButtons(inventory);
        if (this.allowsPlaceholders)
            this.fillWithPlaceholders(inventory);

        // Add this inventory to the currently open menus and open it.
        Arachi.OPEN_MENUS.put(player.getUniqueId(), this);
        player.openInventory(inventory);

        this.onOpen();
    }

    public void close(Player player) {
        if (this.isPersistent()) return;
        Arachi.OPEN_MENUS.remove(player.getUniqueId());
        player.closeInventory();
    }

    public void addAllButtons(Inventory inventory) {
        for (Map.Entry<Integer, Button> buttonEntry : this.getMenuButtons().entrySet())
            inventory.setItem(buttonEntry.getKey(), buttonEntry.getValue().getItem());
    }

    private void fillWithPlaceholders(Inventory inventory) {
        if (!this.allowsPlaceholders) return;
        for (int index = 0; index < inventory.getSize(); index++) {
            if (this.getMenuButtons().get(index) != null) continue;
            this.getMenuButtons().put(index, this.placeholderButton);
            inventory.setItem(index, this.placeholderButton.getItem());
        }
    }

    public int getSize(Map<Integer, Button> buttons) {
        int highest = 0;
        for (int buttonValue : buttons.keySet())
            if (buttonValue > highest) highest = buttonValue;
        return (int) (Math.ceil((highest + 1) / 9D) * 9D);
    }

}
