package io.github.simplycmd.oplogger;

import java.io.IOException;
import java.net.MalformedURLException;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin
{
    private static String url;
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        url = this.getConfig().getString("url");

        getLogger().info("OPlogger is now enabled! Welcome!");
        sendDiscordMessage("OPlogger is now enabled! Welcome!");
        new TheListener(this);
    }

    public static void sendDiscordMessage(String message) {
        DiscordWebhook webhook = new DiscordWebhook(url);
        webhook.setContent(message);
        try {
            webhook.execute();
        } catch (MalformedURLException e) {
            System.out.println("[MinecraftDiscordWebhook] Invalid webhook URL");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("OPlogger is now disabled. Goodbye!");
        sendDiscordMessage("OPlogger is now disabled. Welcome!");
    }
}
