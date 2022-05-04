package me.pairo.arachi.types;

import me.pairo.arachi.types.impl.Button;

import java.util.Map;

public interface IMenu {

    String getTitle();

    void setPersistent(boolean persistent);

    boolean isPersistent();

    Map<Integer, Button> getMenuButtons();

    void onOpen();

    void onClose();

}
