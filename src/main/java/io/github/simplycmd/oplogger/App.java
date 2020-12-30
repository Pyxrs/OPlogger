package io.github.simplycmd.oplogger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin
{
    @Override
    public void onEnable() {
        getLogger().info("Hello, SpigotMC!");
        new TheListener(this);
    }
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }
    public static void log(String message) {
        Bukkit.getLogger().info(message);
    }
}
