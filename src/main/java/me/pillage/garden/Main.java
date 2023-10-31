package me.pillage.garden;

import me.pillage.garden.Utils.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been enabled!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Need help?");
        Logger.log(Logger.LogLevel.INFO, "Join our discord:");
    }

    @Override
    public void onDisable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been disabled!");
        Logger.log(Logger.LogLevel.INFO, "Thank you for using Gardens!");
        Logger.log(Logger.LogLevel.INFO, "See you soon!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
    }
}
