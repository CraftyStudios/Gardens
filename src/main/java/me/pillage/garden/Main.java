package me.pillage.garden;

import me.pillage.garden.Utils.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import me.pillage.garden.storage.GPlayer;
import me.pillage.garden.storage.Levels;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Map<UUID, GPlayer> gPlayers = new HashMap<>();
    public static Map<Integer, Levels> levels = new HashMap<>();
    
    @Override
    public void onEnable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been enabled!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
    }

    @Override
    public void onDisable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been disabled!");
        Logger.log(Logger.LogLevel.INFO, "Thank you for using Gardens!");
        Logger.log(Logger.LogLevel.INFO, "See you soon!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
    }

    private void cacheGPlayers() {} //TODO
    private void saveGPlayers() {} //TODO

    private void cacheLevels() {} //TODO
    private void saveLevels() {} //TODO

    public static GPlayer getGPlayer(UUID uuid) {
        return gPlayers.get(uuid);
    }
}
