package me.pairo.arachi.menu;

import me.pairo.arachi.menu.impl.Button;

import java.util.Map;

public interface IMenu {

    String getTitle();

    void setAllowingPlaceholders(boolean allowsPlaceholders);

    boolean isAllowingPlaceholders();

    void setPersistent(boolean persistent);

    boolean isPersistent();

    Map<Integer, Button> getMenuButtons();

    void onOpen();

    void onClose();

}
