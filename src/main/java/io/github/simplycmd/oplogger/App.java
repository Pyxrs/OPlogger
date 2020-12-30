package io.github.simplycmd.oplogger;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.simplycmd.oplogger.DiscordWebhook.EmbedObject;

public class App extends JavaPlugin
{
    private static String url;
    public static Boolean exclusivelogging;
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        url = this.getConfig().getString("URL");
        exclusivelogging = this.getConfig().getBoolean("Only log OPs");

        EmbedObject enable = new EmbedObject();
        enable.setTitle("OPlogger Enabled");
        enable.setDescription("OPlogger is now enabled! Welcome!");
        enable.setColor(Color.GREEN);
        sendDiscordMessage(enable);

        getLogger().info("OPlogger is now enabled! Welcome!");

        new TheListener(this);
    }

    public static void sendDiscordMessage(EmbedObject embed) {
        DiscordWebhook webhook = new DiscordWebhook(url);
        webhook.addEmbed(embed);
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
        EmbedObject disable = new EmbedObject();
        disable.setTitle("OPlogger Disabled");
        disable.setDescription("OPlogger is now disabled. Goodbye!");
        disable.setColor(Color.RED);
        sendDiscordMessage(disable);

        getLogger().info("OPlogger is now disabled. Goodbye!");
    }
}
