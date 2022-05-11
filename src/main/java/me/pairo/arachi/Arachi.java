package me.pairo.arachi;

import lombok.Getter;
import me.pairo.arachi.menu.listener.MenuListener;
import me.pairo.arachi.menu.impl.Menu;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Arachi {

    private static Arachi instance;
    @Getter
    private final JavaPlugin plugin;
    public static final HashMap<UUID, Menu> OPEN_MENUS = new HashMap<>();
    public static final List<ClickType> FORBIDDEN_CLICK_TYPES = List.of(
            ClickType.SHIFT_LEFT,
            ClickType.SHIFT_RIGHT,
            ClickType.DROP,
            ClickType.CONTROL_DROP,
            ClickType.NUMBER_KEY
    );

    public Arachi(JavaPlugin plugin) {
        instance = this;
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(new MenuListener(), plugin);
    }

    public static Arachi get() {
        return instance;
    }

}
