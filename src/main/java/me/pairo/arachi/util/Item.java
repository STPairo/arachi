package me.pairo.arachi.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Item {
    ItemStack item;

    public Item(Material material) {
        item = new ItemStack(material);
    }

    public Item() {
        item = new ItemStack(Material.BEDROCK);
    }

    public Item(ItemStack itemStack) {
        this.item = itemStack;
    }

    public Item setName(String name) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return this;
        meta.setDisplayName(new Colorizer(name).colorize('&').toString());
        item.setItemMeta(meta);
        return this;
    }

    public Item setMaterial(Material material) {
        item.setType(material);
        return this;
    }

    public Item setMaterialByName(String material) {
        item.setType(Objects.requireNonNull(Material.getMaterial(material)));
        return this;
    }

    @SuppressWarnings("deprecation")
    public Item setDurability(short durability) {
        item.setDurability(durability);
        return this;
    }

    public Item setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public Item setLore(String... lore) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return this;

        List<String> loreLines= new ArrayList<>();
        Arrays.stream(lore).forEach(s -> loreLines.add(new Colorizer(s).colorize('&').toString()));

        meta.setLore(loreLines);
        item.setItemMeta(meta);
        return this;
    }

    public Item addEnchantment(Enchantment enchantment, int level) {
        item.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public Item removeEnchantment(Enchantment enchantment) {
        item.removeEnchantment(enchantment);
        return this;
    }

    public ItemStack toItemStack() {
        return item;
    }

}
