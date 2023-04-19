package me.pillage.garden.Guis;

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

import java.util.HashMap;
import java.util.Map;

public class Gardens implements CommandExecutor, Listener {
    Map<String, Integer> playerGardenLevel = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (cmd.getName().equalsIgnoreCase("gardens")) {
            player.openInventory(GardenGUI(player));
        }
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

        ItemStack gardenLevel = new ItemStack(Material.SUNFLOWER);
        ItemMeta gardenLevelMeta = gardenLevel.getItemMeta();
        assert gardenLevelMeta != null;
        gardenLevelMeta.setDisplayName("Garden Level" + playerGardenLevel);


        return GardenGUI;
    }
}
