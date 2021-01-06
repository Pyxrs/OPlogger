package io.github.simplycmd.oplogger;

import java.awt.Color;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import io.github.simplycmd.oplogger.DiscordWebhook.EmbedObject;

public class CommandPreprocessListener implements Listener {
    public CommandPreprocessListener(App plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (App.command_blacklist.contains(event.getMessage().split(" ", 2)[0]) == false) {
            if (App.exclusive_logging == false) {
                EmbedObject command = new EmbedObject();
                command.setTitle("Command Executed!");
                command.setDescription("**" + event.getPlayer().getDisplayName() + "** just executed command **" + event.getMessage() + " **");
                command.setColor(Color.CYAN);
                App.sendDiscordMessage(command);
            } else if (event.getPlayer().isOp() == true) {
                EmbedObject command = new EmbedObject();
                command.setTitle("Command Executed!");
                command.setDescription("**" + event.getPlayer().getDisplayName() + "** just executed command **" + event.getMessage() + " **");
                command.setColor(Color.CYAN);
                App.sendDiscordMessage(command);
            }
        }
    }
}
