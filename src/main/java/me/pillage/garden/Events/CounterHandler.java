package me.pillage.garden.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static me.pillage.garden.Events.GardenEventHandler.player;
import static me.pillage.garden.Events.GardenEventHandler.plugin;

public class CounterHandler implements Listener {
    List<String> wheatFortuneItems = plugin.getConfig().getStringList("Wheat-Fortune-Items");
    List<String> carrotFortuneItems = plugin.getConfig().getStringList("Carrot-Fortune-Items");
    List<String> potatoFortuneItems = plugin.getConfig().getStringList("Potato-Fortune-Items");
    List<String> beetrootFortuneItems = plugin.getConfig().getStringList("Beetroot-Fortune-Items");
    List<String> netherWartFortuneItems = plugin.getConfig().getStringList("Nether-Wart-Fortune-Items");
    List<String> cocoaFortuneItems = plugin.getConfig().getStringList("Cocoa-Fortune-Items");
    List<String> sugarCaneFortuneItems = plugin.getConfig().getStringList("Sugar-Cane-Fortune-Items");
    List<String> bambooFortuneItems = plugin.getConfig().getStringList("Bamboo-Fortune-Items");
    List<String> cactusFortuneItems = plugin.getConfig().getStringList("Cactus-Fortune-Items");
    List<String> melonFortuneItems = plugin.getConfig().getStringList("Melon-Fortune-Items");
    List<String> pumpkinFortuneItems = plugin.getConfig().getStringList("Pumpkin-Fortune-Items");

    public static Map<Player, Integer> wheatCounter = new HashMap<>();
    public static Map<Player, Integer> carrotCounter = new HashMap<>();
    public static Map<Player, Integer> potatoCounter = new HashMap<>();
    public static Map<Player, Integer> beetrootCounter = new HashMap<>();
    public static Map<Player, Integer> netherWartCounter = new HashMap<>();
    public static Map<Player, Integer> cocoaCounter = new HashMap<>();
    public static Map<Player, Integer> sugarCaneCounter = new HashMap<>();
    public static Map<Player, Integer> bambooCounter = new HashMap<>();
    public static Map<Player, Integer> cactusCounter = new HashMap<>();
    public static Map<Player, Integer> melonCounter = new HashMap<>();
    public static Map<Player, Integer> pumpkinCounter = new HashMap<>();

    private int wheatCounterFloat;
    private int carrotCounterFloat;
    private int potatoCounterFloat;
    private int beetrootCounterFloat;
    private int netherWartCounterFloat;
    private int cocoaCounterFloat;
    private int sugarCaneCounterFloat;
    private int bambooCounterFloat;
    private int cactusCounterFloat;
    private int melonCounterFloat;
    private int pumpkinCounterFloat;

    public CounterHandler() {

    }

    @EventHandler
    public void addCounter(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType().toString().toLowerCase().contains("hoe") || wheatFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.WHEAT) {
                    wheatCounterFloat += drop.getAmount();
                }
            }
            wheatCounter.put(player, wheatCounter.getOrDefault(player, 0) + wheatCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || carrotFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.CARROTS) {
                    carrotCounterFloat += drop.getAmount();
                }
            }
            carrotCounter.put(player, carrotCounter.getOrDefault(player, 0) + carrotCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || potatoFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.POTATOES) {
                    potatoCounterFloat += drop.getAmount();
                }
            }
            potatoCounter.put(player, potatoCounter.getOrDefault(player, 0) + potatoCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || beetrootFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.BEETROOTS) {
                    beetrootCounterFloat += drop.getAmount();
                }
            }
            beetrootCounter.put(player, beetrootCounter.getOrDefault(player, 0) + beetrootCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || netherWartFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.NETHER_WART) {
                    netherWartCounterFloat += drop.getAmount();
                }
            }
            netherWartCounter.put(player, netherWartCounter.getOrDefault(player, 0) + netherWartCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || cocoaFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.COCOA) {
                    cocoaCounterFloat += drop.getAmount();
                }
            }
            cocoaCounter.put(player, cocoaCounter.getOrDefault(player, 0) + cocoaCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || sugarCaneFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.SUGAR_CANE) {
                    sugarCaneCounterFloat += drop.getAmount();
                }
            }
            sugarCaneCounter.put(player, sugarCaneCounter.getOrDefault(player, 0) + sugarCaneCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || bambooFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.BAMBOO) {
                    bambooCounterFloat += drop.getAmount();
                }
            }
            bambooCounter.put(player, bambooCounter.getOrDefault(player, 0) + bambooCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || cactusFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.CACTUS) {
                    cactusCounterFloat += drop.getAmount();
                }
            }
            cactusCounter.put(player, cactusCounter.getOrDefault(player, 0) + cactusCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || melonFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.MELON) {
                    melonCounterFloat += drop.getAmount();
                }
            }
            melonCounter.put(player, melonCounter.getOrDefault(player, 0) + melonCounterFloat);
        }

        if (item.getType().toString().toLowerCase().contains("hoe") || pumpkinFortuneItems.contains(Objects.requireNonNull(item.getItemMeta()).getDisplayName())) {
            for (ItemStack drop : block.getDrops(item)) {
                if (drop.getType() == Material.PUMPKIN) {
                    pumpkinCounterFloat += drop.getAmount();
                }
            }
            pumpkinCounter.put(player, pumpkinCounter.getOrDefault(player, 0) + pumpkinCounterFloat);
        }
    }

    public static String counterText(Material material) {
        StringBuilder wheatCounterText = new StringBuilder();
        StringBuilder carrotCounterText = new StringBuilder();
        StringBuilder potatoCounterText = new StringBuilder();
        StringBuilder beetrootCounterText = new StringBuilder();
        StringBuilder netherWartCounterText = new StringBuilder();
        StringBuilder cocoaCounterText = new StringBuilder();
        StringBuilder sugarCaneCounterText = new StringBuilder();
        StringBuilder bambooCounterText = new StringBuilder();
        StringBuilder cactusCounterText = new StringBuilder();
        StringBuilder melonCounterText = new StringBuilder();
        StringBuilder pumpkinCounterText = new StringBuilder();
        
        switch(material) {
            case WHEAT:
                wheatCounterText.append("Wheat Counter: ").append(wheatCounter.get(player));
                return wheatCounterText.toString();
            case CARROTS:
                carrotCounterText.append("Carrot Counter: ").append(carrotCounter.get(player));
                return carrotCounterText.toString();
            case POTATOES:
                potatoCounterText.append("Potato Counter: ").append(potatoCounter.get(player));
                return potatoCounterText.toString();
            case BEETROOTS:
                beetrootCounterText.append("Beetroot Counter: ").append(beetrootCounter.get(player));
                return beetrootCounterText.toString();
            case NETHER_WART:
                netherWartCounterText.append("Nether Wart Counter: ").append(netherWartCounter.get(player));
                return netherWartCounterText.toString();
            case COCOA:
                cocoaCounterText.append("Cocoa Counter: ").append(cocoaCounter.get(player));
                return cocoaCounterText.toString();
            case SUGAR_CANE:
                sugarCaneCounterText.append("Sugar Cane Counter: ").append(sugarCaneCounter.get(player));
                return sugarCaneCounterText.toString();
            case BAMBOO:
                bambooCounterText.append("Bamboo Counter: ").append(bambooCounter.get(player));
                return bambooCounterText.toString();
            case CACTUS:
                cactusCounterText.append("Cactus Counter: ").append(cactusCounter.get(player));
                return cactusCounterText.toString();
            case MELON:
                melonCounterText.append("Melon Counter: ").append(melonCounter.get(player));
                return melonCounterText.toString();
            case PUMPKIN:
                pumpkinCounterText.append("Pumpkin Counter: ").append(pumpkinCounter.get(player));
                return pumpkinCounterText.toString();
            default:
                break;
        }
        return "No crop found";
    }

    public static void resetCounter(Material material) {
        switch(material) {
            case WHEAT:
                wheatCounter.put(player, 0);
                break;
            case CARROTS:
                carrotCounter.put(player, 0);
                break;
            case POTATOES:
                potatoCounter.put(player, 0);
                break;
            case BEETROOTS:
                beetrootCounter.put(player, 0);
                break;
            case NETHER_WART:
                netherWartCounter.put(player, 0);
                break;
            case COCOA:
                cocoaCounter.put(player, 0);
                break;
            case SUGAR_CANE:
                sugarCaneCounter.put(player, 0);
                break;
            case BAMBOO:
                bambooCounter.put(player, 0);
                break;
            case CACTUS:
                cactusCounter.put(player, 0);
                break;
            case MELON:
                melonCounter.put(player, 0);
                break;
            case PUMPKIN:
                pumpkinCounter.put(player, 0);
                break;
            default:
                break;
        }
    }
}
