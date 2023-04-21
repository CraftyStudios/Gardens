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
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class GardenEventHandler implements Listener {
    public static float gardenXP = 0;
    public static Map<Player, Integer> wheatFortune = new HashMap<>();
    public static Map<Player, Integer> carrotFortune = new HashMap<>();
    public static Map<Player, Integer> potatoFortune = new HashMap<>();
    public static Map<Player, Integer> beetrootFortune = new HashMap<>();
    public static Map<Player, Integer> netherWartFortune = new HashMap<>();
    public static Map<Player, Integer> cocoaFortune = new HashMap<>();
    public static Map<Player, Integer> sugarCaneFortune = new HashMap<>();
    public static Map<Player, Integer> bambooFortune = new HashMap<>();
    public static Map<Player, Integer> cactusFortune = new HashMap<>();
    public static Map<Player, Integer> melonFortune = new HashMap<>();
    public static Map<Player, Integer> pumpkinFortune = new HashMap<>();

    public static int farmingFortune = 0;
    public static int gardenLevel = 1;
    public static float multiplier = 1.5f;
    public static float xpRequired = 10f;
    public static Player player;
    private Map<String, Integer> playerGardenLevel = new HashMap<>();
    private Map<String, Integer> farmingFortunes = new HashMap<>();
    public static Plugin plugin = Bukkit.getPluginManager().getPlugin("Gardens");

    private boolean isCrop(Material material) {
        return material == Material.WHEAT || material == Material.CARROTS || material == Material.POTATOES || material == Material.BEETROOTS || material == Material.NETHER_WART || material == Material.COCOA || material == Material.SUGAR_CANE || material == Material.BAMBOO || material == Material.CACTUS || material == Material.MELON || material == Material.PUMPKIN;
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
                    int initialWheatDrops = farmingFortunes.get(player.getName()) + wheatFortune.get(player);
                    int wheatChanceForGuaranteedDrops = (int) Math.floor(initialWheatDrops);
                    int wheatChanceForNextTierDrops = initialWheatDrops - wheatChanceForGuaranteedDrops;
                    int drops;
                    if (Math.random() < wheatChanceForNextTierDrops) {
                        drops = wheatChanceForGuaranteedDrops + 2;
                    } else {
                        drops = wheatChanceForGuaranteedDrops + 1;
                    }
                    ItemStack wheat = new ItemStack(Material.WHEAT, drops);
                    block.breakNaturally(wheat);
                    break;
                case CARROTS:
                    int initialCarrotDrops = farmingFortunes.get(player.getName() + carrotFortune.get(player));
                    int carrotChanceForGuaranteedDrops = (int) Math.floor(initialCarrotDrops);
                    int carrotChanceForNextTierDrops = initialCarrotDrops - carrotChanceForGuaranteedDrops;
                    int carrotDrops;
                    if (Math.random() < carrotChanceForNextTierDrops) {
                        carrotDrops = carrotChanceForGuaranteedDrops + 2;
                    } else {
                        carrotDrops = carrotChanceForGuaranteedDrops + 1;
                    }
                    ItemStack carrots = new ItemStack(Material.CARROTS, carrotDrops);
                    block.breakNaturally(carrots);
                    break;
                case POTATOES:
                    int initialPotatoDrops = farmingFortunes.get(player.getName() + potatoFortune.get(player));
                    int potatoChanceForGuaranteedDrops = (int) Math.floor(initialPotatoDrops);
                    int potatoChanceForNextTierDrops = initialPotatoDrops - potatoChanceForGuaranteedDrops;
                    int potatoDrops;
                    if (Math.random() < potatoChanceForNextTierDrops) {
                        potatoDrops = potatoChanceForGuaranteedDrops + 2;
                    } else {
                        potatoDrops = potatoChanceForGuaranteedDrops + 1;
                    }
                    ItemStack potatoes = new ItemStack(Material.POTATOES, potatoDrops);
                    block.breakNaturally(potatoes);
                    break;
                case BEETROOTS:
                    int initialBeetrootDrops = farmingFortunes.get(player.getName() + beetrootFortune.get(player));
                    int beetrootChanceForGuaranteedDrops = (int) Math.floor(initialBeetrootDrops);
                    int beetrootChanceForNextTierDrops = initialBeetrootDrops - beetrootChanceForGuaranteedDrops;
                    int beetrootDrops;
                    if (Math.random() < beetrootChanceForNextTierDrops) {
                        beetrootDrops = beetrootChanceForGuaranteedDrops + 2;
                    } else {
                        beetrootDrops = beetrootChanceForGuaranteedDrops + 1;
                    }
                    ItemStack beetroot = new ItemStack(Material.BEETROOTS, beetrootDrops);
                    block.breakNaturally(beetroot);
                    break;
                case NETHER_WART:
                    int initialNetherWartDrops = farmingFortunes.get(player.getName() + netherWartFortune.get(player));
                    int netherWartChanceForGuaranteedDrops = (int) Math.floor(initialNetherWartDrops);
                    int netherWartChanceForNextTierDrops = initialNetherWartDrops - netherWartChanceForGuaranteedDrops;
                    int netherWartDrops;
                    if (Math.random() < netherWartChanceForNextTierDrops) {
                        netherWartDrops = netherWartChanceForGuaranteedDrops + 2;
                    } else {
                        netherWartDrops = netherWartChanceForGuaranteedDrops + 1;
                    }
                    ItemStack netherWart = new ItemStack(Material.NETHER_WART, netherWartDrops);
                    block.breakNaturally(netherWart);
                    break;
                case COCOA:
                    int initialCocoaDrops = farmingFortunes.get(player.getName() + cocoaFortune.get(player));
                    int cocoaChanceForGuaranteedDrops = (int) Math.floor(initialCocoaDrops);
                    int cocoaChanceForNextTierDrops = initialCocoaDrops - cocoaChanceForGuaranteedDrops;
                    int cocoaDrops;
                    if (Math.random() < cocoaChanceForNextTierDrops) {
                        cocoaDrops = cocoaChanceForGuaranteedDrops + 2;
                    } else {
                        cocoaDrops = cocoaChanceForGuaranteedDrops + 1;
                    }
                    ItemStack cocoa = new ItemStack(Material.COCOA_BEANS, cocoaDrops);
                    block.breakNaturally(cocoa);
                    break;
                case SUGAR_CANE:
                    int initialSugarCaneDrops = farmingFortunes.get(player.getName() + sugarCaneFortune.get(player));
                    int sugarCaneChanceForGuaranteedDrops = (int) Math.floor(initialSugarCaneDrops);
                    int sugarCaneChanceForNextTierDrops = initialSugarCaneDrops - sugarCaneChanceForGuaranteedDrops;
                    int sugarCaneDrops;
                    if (Math.random() < sugarCaneChanceForNextTierDrops) {
                        sugarCaneDrops = sugarCaneChanceForGuaranteedDrops + 2;
                    } else {
                        sugarCaneDrops = sugarCaneChanceForGuaranteedDrops + 1;
                    }
                    ItemStack sugarCane = new ItemStack(Material.SUGAR_CANE, sugarCaneDrops);
                    block.breakNaturally(sugarCane);
                    break;
                case MELON:
                    int initialMelonDrops = farmingFortunes.get(player.getName() + melonFortune.get(player));
                    int melonChanceForGuaranteedDrops = (int) Math.floor(initialMelonDrops);
                    int melonChanceForNextTierDrops = initialMelonDrops - melonChanceForGuaranteedDrops;
                    int melonDrops;
                    if (Math.random() < melonChanceForNextTierDrops) {
                        melonDrops = melonChanceForGuaranteedDrops + 2;
                    } else {
                        melonDrops = melonChanceForGuaranteedDrops + 1;
                    }
                    ItemStack melon = new ItemStack(Material.MELON_SLICE, melonDrops);
                    block.breakNaturally(melon);
                    break;
                case PUMPKIN:
                    int initialPumpkinDrops = farmingFortunes.get(player.getName() + pumpkinFortune.get(player));
                    int pumpkinChanceForGuaranteedDrops = (int) Math.floor(initialPumpkinDrops);
                    int pumpkinChanceForNextTierDrops = initialPumpkinDrops - pumpkinChanceForGuaranteedDrops;
                    int pumpkinDrops;
                    if (Math.random() < pumpkinChanceForNextTierDrops) {
                        pumpkinDrops = pumpkinChanceForGuaranteedDrops + 2;
                    } else {
                        pumpkinDrops = pumpkinChanceForGuaranteedDrops + 1;
                    }
                    ItemStack pumpkin = new ItemStack(Material.PUMPKIN_SEEDS, pumpkinDrops);
                    block.breakNaturally(pumpkin);
                    break;
                case CACTUS:
                    int initialCactusDrops = farmingFortunes.get(player.getName() + cactusFortune.get(player));
                    int cactusChanceForGuaranteedDrops = (int) Math.floor(initialCactusDrops);
                    int cactusChanceForNextTierDrops = initialCactusDrops - cactusChanceForGuaranteedDrops;
                    int cactusDrops;
                    if (Math.random() < cactusChanceForNextTierDrops) {
                        cactusDrops = cactusChanceForGuaranteedDrops + 2;
                    } else {
                        cactusDrops = cactusChanceForGuaranteedDrops + 1;
                    }
                    ItemStack cactus = new ItemStack(Material.CACTUS, cactusDrops);
                    block.breakNaturally(cactus);
                    break;
                case BAMBOO:
                    int initialBambooDrops = farmingFortunes.get(player.getName() + bambooFortune.get(player));
                    int bambooChanceForGuaranteedDrops = (int) Math.floor(initialBambooDrops);
                    int bambooChanceForNextTierDrops = initialBambooDrops - bambooChanceForGuaranteedDrops;
                    int bambooDrops;
                    if (Math.random() < bambooChanceForNextTierDrops) {
                        bambooDrops = bambooChanceForGuaranteedDrops + 2;
                    } else {
                        bambooDrops = bambooChanceForGuaranteedDrops + 1;
                    }
                    ItemStack bamboo = new ItemStack(Material.BAMBOO, bambooDrops);
                    block.breakNaturally(bamboo);
                    break;
            }
        }
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