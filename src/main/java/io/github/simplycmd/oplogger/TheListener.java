package io.github.simplycmd.oplogger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class TheListener implements Listener {
    public TheListener(App plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " just executed command " + event.getMessage());
        App.sendDiscordMessage(event.getPlayer().getDisplayName() + " just executed command " + event.getMessage());
    }
}
