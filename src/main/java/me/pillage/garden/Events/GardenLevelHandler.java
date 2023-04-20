package me.pillage.garden.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Material.WHEAT;

public class GardenLevelHandler implements Listener {
    public static float gardenXP = 0;
    public static int farmingFortune = 0;
    public static int gardenLevel = 1;
    public static float multiplier = 1.5f;
    public static float xpRequired = 10f;
    public static Player player;
    private Map<String, Integer> playerGardenLevel = new HashMap<>();
    private Map<String, Integer> farmingFortunes = new HashMap<>();
    public static Plugin plugin = Bukkit.getPluginManager().getPlugin("Gardens");

    private boolean isCrop(Material material) {
        return material == WHEAT || material == Material.CARROTS || material == Material.POTATOES || material == Material.BEETROOTS;
    }

    @EventHandler
    public void cropHandler(BlockBreakEvent event) {
        Block block = event.getBlock();
        float chanceForMultipliedDrops = (int) (1 * (farmingFortune * 0.1));

        farmingFortunes.put(player.getName(), (int) chanceForMultipliedDrops);

        player = event.getPlayer();
        World world = event.getBlock().getWorld();
        if (world.getName().equalsIgnoreCase(plugin.getConfig().getString("GardenWorld")) && isCrop(event.getBlock().getType())) {
            gardenXP++;
            calculateGardenLevel();
        }
        playerGardenLevel.put(player.getName(), gardenLevel);

        if (isCrop(block.getType())) {
            switch(block.getType()) {
                case WHEAT:
                    int initialWheatDrops = farmingFortunes.get(player.getName());
                    int chanceForGuaranteedDrops = (int) Math.floor(initialWheatDrops);
                    int chanceForNextTierDrops = (int) (initialWheatDrops - chanceForGuaranteedDrops);
                    int drops;
                    if (Math.random() < 0.5) {
                        drops = initialWheatDrops + chanceForNextTierDrops;
                    } else {
                        drops = initialWheatDrops + chanceForGuaranteedDrops;
                    }
                    ItemStack wheat = new ItemStack(Material.WHEAT, drops);
                    block.breakNaturally();
                    break;
                case CARROTS:
                    int initialCarrotDrops = farmingFortunes.get(player.getName());
                    int carrotChanceForGuaranteedDrops = (int) Math.floor(initialCarrotDrops);
                    int carrotChanceForNextTierDrops = (int) (initialCarrotDrops - carrotChanceForGuaranteedDrops);
                    int carrotDrops;
                    if (Math.random() < 0.5) {
                        carrotDrops = initialCarrotDrops + carrotChanceForNextTierDrops;
                    } else {
                        carrotDrops = initialCarrotDrops + carrotChanceForGuaranteedDrops;
                    }
                    ItemStack carrots = new ItemStack(Material.CARROTS, carrotDrops);
                    block.breakNaturally();
                    break;
                case POTATOES:
                    int initialPotatoDrops = farmingFortunes.get(player.getName());
                    int potatoChanceForGuaranteedDrops = (int) Math.floor(initialPotatoDrops);
                    int potatoChanceForNextTierDrops = (int) (initialPotatoDrops - potatoChanceForGuaranteedDrops);
                    int potatoDrops;
                    if (Math.random() < 0.5) {
                        potatoDrops = initialPotatoDrops + potatoChanceForNextTierDrops;
                    } else {
                        potatoDrops = initialPotatoDrops + potatoChanceForGuaranteedDrops;
                    }
                    ItemStack potatoes = new ItemStack(Material.POTATOES, potatoDrops);
                    block.breakNaturally();
                    break;
                case BEETROOTS:
                    int initialBeetrootDrops = farmingFortunes.get(player.getName());
                    int beetrootChanceForGuaranteedDrops = (int) Math.floor(initialBeetrootDrops);
                    int beetrootChanceForNextTierDrops = (int) (initialBeetrootDrops - beetrootChanceForGuaranteedDrops);
                    int beetrootDrops;
                    if (Math.random() < 0.5) {
                        beetrootDrops = initialBeetrootDrops + beetrootChanceForNextTierDrops;
                    } else {
                        beetrootDrops = initialBeetrootDrops + beetrootChanceForGuaranteedDrops;
                    }
                    ItemStack beetroot = new ItemStack(Material.BEETROOTS, beetrootDrops);
                    block.breakNaturally();
                    break;
            }
        }
    }

    public void getGardenLevel(Player player) {
        playerGardenLevel.get(player.getName());
    }

    public static void calculateGardenLevel() {
        xpRequired = (float) (xpRequired * Math.pow(multiplier, gardenLevel - 1));

        while (gardenXP >= xpRequired) {
            gardenLevel++;
        }
    }

    public static String progressBar() {
        StringBuilder progressBar = new StringBuilder();
        progressBar.append("[");
        int numberOfBars = (int) (gardenXP / xpRequired * 10);
        ChatColor barColor = ChatColor.AQUA;
        ChatColor emptyColor = ChatColor.DARK_GRAY;
        for (int i = 0; i < 20; i++) {
            if (i < numberOfBars) {
                progressBar.append(barColor).append("-");
            } else {
                progressBar.append(emptyColor).append("-");
            }
        }
        progressBar.append("]");
        return progressBar.toString();
    }
}

