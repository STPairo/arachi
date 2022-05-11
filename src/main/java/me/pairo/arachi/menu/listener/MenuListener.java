package me.pairo.arachi.menu.listener;

import me.pairo.arachi.Arachi;
import me.pairo.arachi.menu.impl.Button;
import me.pairo.arachi.menu.impl.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Menu openMenu = Arachi.OPEN_MENUS.get(player.getUniqueId());

        // If openMenu is null, the player has no menu open.
        if (openMenu == null) return;
        // Cancel the event so that the player can't mess with the menu.
        event.setCancelled(true);

        // If the slot clicked in the event corresponds to an actual button of the menu (and not to a placeholder).
        if (openMenu.getMenuButtons().containsKey(event.getSlot())) {
            Button button = openMenu.getMenuButtons().get(event.getSlot());
            button.clicked(player, openMenu, event.getClick(), event.getCurrentItem(), event.getHotbarButton(), event.getSlot());
        }

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Menu openMenu = Arachi.OPEN_MENUS.get(player.getUniqueId());

        if (openMenu == null) return;
        Arachi.OPEN_MENUS.remove(player.getUniqueId());

        if (openMenu.isPersistent()) {
            // If the menu is persistent, open it up again.
            // The reason for the "runTaskLater" is IT DOES NOT WORK WITHOUT IT JESUS FUCK IT TOOK ME FOREVER TO FIGURE OUT.
            // Let me know if this is too much voodoo for our purposes.
            Bukkit.getScheduler().runTaskLater(Arachi.get().getPlugin(), () -> openMenu.open(player), 4L);
            return;
        }

        openMenu.onClose();
    }

}