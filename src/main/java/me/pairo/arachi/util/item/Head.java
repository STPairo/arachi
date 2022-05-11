package me.pairo.arachi.util.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

public class Head extends Item {

    public Head() {
        this.item = new Item(Material.PLAYER_HEAD).toItemStack();
    }

    public Head setOwner(Player player) {
        SkullMeta meta = (SkullMeta) this.item.getItemMeta();
        if (meta == null) return this;
        meta.setOwningPlayer(player);
        this.item.setItemMeta(meta);
        return this;
    }

}
