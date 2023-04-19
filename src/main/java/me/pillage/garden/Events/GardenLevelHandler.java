package me.pillage.garden.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class GardenLevelHandler {
    public static float gardenXP = 0;
    public static int gardenLevel = 1;
    public static float multiplier = 1.5f;
    public static float xpRequired = 10f;

    static Player player = (Player) Bukkit.getOnlinePlayers();
    static Plugin plugin = Bukkit.getPluginManager().getPlugin("Gardens");

    public static void getGardenLevel() {
        Map<String, Integer> gardenLevel = new HashMap<>();
        String playerName = player.getName();
//        gardenLevel.put(playerName, level);
    }

    public static void calculateGardenLevel() {
        xpRequired = (float) (xpRequired * Math.pow(multiplier, gardenLevel - 1));

        while (gardenXP >= xpRequired) {
            gardenLevel++;
            xpRequired = xpRequired * multiplier;
        }
    }

    @EventHandler
    public void cropHandler(BlockBreakEvent event) {
        World world = event.getBlock().getWorld();
        if (world.getName().equalsIgnoreCase(plugin.getConfig().getString("GardenWorld")) && isCrop(event.getBlock().getType())) {
            gardenXP++;
            calculateGardenLevel();
        }
    }
        private boolean isCrop(Material material) {
            return material == Material.WHEAT || material == Material.CARROTS || material == Material.POTATOES || material == Material.BEETROOTS;
        }

    }

