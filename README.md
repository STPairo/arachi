# arachi
arachi is a project aimed to simplify the creation of inventory-based GUI menus on Minecraft Java Edition servers.

# Installation
To use this library, clone this repository and compile it using maven.

```sh
git clone https://github.com/STPairo/arachi
cd arachi
mvn clean install
```

then, you can add the .jar archive to your project as a dependency,

# Usage
First off, initialise the API in your plugin's main class.

```java
public class YourPlugin extends JavaPlugin {

    private Arachi arachi;

    @Override
    public void onEnable() {
        // [...]
        
        arachi = new Arachi(this);
        
        // The rest of your onEnable method
    }

```

and from now on, every menu created extending the Menu class will be automatically handled.

# Menu creation example

```java
public class TestMenu extends Menu {

    // Persistent menus can only be closed with the click of a specific button
    private boolean persistent = false;
    
    @Override
    public String getTitle() {
        return "&6&lTest Menu";
    }

    @Override
    public void setPersistent(boolean persistent) {
        this.persistent = persistent; 
    }

    @Override
    public boolean isPersistent() { 
        return persistent; 
    }

    @Override
    public Map<Integer, Button> getMenuButtons() {
        Map<Integer, Button> buttons = new HashMap<>();
        buttons.put(0, new TestButton());
        return buttons;
    }

    @Override
    public void onOpen() {}

    @Override
    public void onClose() {}

}

```

# Button creation example

```java
public class TestButton extends Button {

    @Override
    public ItemStack getItem() {
        return new Item(Material.DIAMOND_SWORD).setName("&aTest Button").toItemStack();
    }

    @Override
    public void clicked(Player player, Menu menu, int slot, ClickType clickType, int hotbarButton) {
        player.sendMessage("You clicked the button!");
    }

}

```
