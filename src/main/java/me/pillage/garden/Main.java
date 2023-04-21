package me.pillage.garden;

import me.pillage.garden.Utils.Logger;
import me.pillage.garden.Enchants.WheatFortune;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {

    private int main;
    BukkitScheduler scheduler = getServer().getScheduler();

    @Override
    public void onEnable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been enabled!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Need help?");
        Logger.log(Logger.LogLevel.INFO, "Join our discord:");

        ItemStack wheatFortuneBook = new ItemStack(Material.ENCHANTED_BOOK);
        ShapedRecipe wheatBookRecipe = WheatFortune.createRecipe(wheatFortuneBook);
        Bukkit.addRecipe(wheatBookRecipe);

        ItemStack carrotFortuneBook = new ItemStack(Material.ENCHANTED_BOOK);
        ShapedRecipe carrotBookRecipe = WheatFortune.createRecipe(carrotFortuneBook);
        Bukkit.addRecipe(carrotBookRecipe);
        main = scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                execute();
            }
        }, 0L, 20L);
    }

    @Override
    public void onDisable() {
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");
        Logger.log(Logger.LogLevel.INFO, "Gardens has been disabled!");
        Logger.log(Logger.LogLevel.INFO, "Thank you for using Gardens!");
        Logger.log(Logger.LogLevel.INFO, "See you soon!");
        Logger.log(Logger.LogLevel.OUTLINE, "------------------------------");

        scheduler.cancelTask(main);
    }

    public void execute() {

    }
}
