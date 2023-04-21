package me.pillage.garden.Guis;

import me.pillage.garden.Events.GardenEventHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static me.pillage.garden.Events.GardenEventHandler.plugin;

public class Gardens implements CommandExecutor, Listener {

    private ItemStack gardenLevelItem;
    private final Map<Player, BukkitRunnable> taskMap = new HashMap<>();

    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (cmd.getName().equalsIgnoreCase("gardens")) {
            player.openInventory(GardenGUI(player));
            startProgressBarUpdateTask(player);
        }
        updateProgressBar(player);
        return false;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType() == Material.BLACK_STAINED_GLASS_PANE){
            event.setCancelled(true);
        }
    }

    public Inventory GardenGUI(Player player) {
        Inventory GardenGUI = Bukkit.createInventory(null, 54, "Gardens");
        ItemStack fillerItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = fillerItem.getItemMeta();
        assert fillerMeta != null;
        fillerMeta.setDisplayName(" ");
        fillerItem.setItemMeta(fillerMeta);
        for (int i = 0; i < 54; i++) {
            GardenGUI.setItem(i, fillerItem);
        }

        gardenLevelItem = new ItemStack(Material.SUNFLOWER);
        ItemMeta gardenLevelMeta = gardenLevelItem.getItemMeta();
        assert gardenLevelMeta != null;
        gardenLevelMeta.setDisplayName("Garden Level" + GardenEventHandler.gardenLevel);
        gardenLevelMeta.setLore(Collections.singletonList("Garden XP: " + GardenEventHandler.gardenXP + "/" + GardenEventHandler.xpRequired + "|" + GardenEventHandler.progressBar()));
        gardenLevelItem.setItemMeta(gardenLevelMeta);
        GardenGUI.setItem(22, gardenLevelItem);

        return GardenGUI;
    }

    private void startProgressBarUpdateTask(Player player) {
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                updateProgressBar(player);
            }
        };
        taskMap.put(player, task);
        task.runTaskTimer(plugin, 0L, 100L);
    }

    private void updateProgressBar(Player player) {
        String progressBar = GardenEventHandler.progressBar();
        ItemMeta gardenLevelMeta = gardenLevelItem.getItemMeta();
        assert gardenLevelMeta != null;
        gardenLevelMeta.setLore(Collections.singletonList("Garden XP: " + GardenEventHandler.gardenXP + "/" + GardenEventHandler.xpRequired + "|" + progressBar));
        gardenLevelItem.setItemMeta(gardenLevelMeta);
        Inventory inventory = player.getOpenInventory().getTopInventory();
        inventory.setItem(22, gardenLevelItem);
    }
}
