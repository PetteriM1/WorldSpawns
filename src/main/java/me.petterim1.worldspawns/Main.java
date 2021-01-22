package me.petterim1.worldspawns;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.plugin.PluginBase;

import java.util.List;

public class Main extends PluginBase implements Listener {

    private List<String> excludedWorlds;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        excludedWorlds = getConfig().getStringList("excludedWorlds");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (!excludedWorlds.contains(e.getPlayer().getLevel().getName())) {
            e.setRespawnPosition(e.getPlayer().getLevel().getSafeSpawn());
        }
    }
}
