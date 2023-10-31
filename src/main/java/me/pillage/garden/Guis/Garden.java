package me.pillage.garden.Guis;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import net.md_5.bungee.api.ChatColor;

public class Garden implements Listener {
    private Inventory inv;

    public Garden() {
        inv = Bukkit.createInventory(null, 27, "Garden Desk");

        initializeItems();
    }

    private void initializeItems() {
        inv.setItem(0, create("&aGarden Level {level}", Material.SUNFLOWER, "&7Earn garden experience by", "&7accepting visitors' offers and", "&7unlocking new milestones!", "&7", "{progress-top}", "{progress-bottom}", "&7", "{levelup-rewards}"));
    }

    private ItemStack create(String name, Material mat, String... lore) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(translate(name));
        meta.setLore(translate(Arrays.asList(lore)));
        item.setItemMeta(meta);
        return item;
    }

    private String translate(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    private List<String> translate(List<String> lore) {
        return lore.stream().map(s -> ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toList());
    }

    public void openInv(HumanEntity entity) {
        Inventory clone = Bukkit.createInventory(null, inv.getSize(), "Garden Desk");
        clone.setContents(
            Arrays.stream(inv.getContents())
                .map(item -> {
                    if (item != null) {
                        ItemMeta meta = item.getItemMeta();
                        if (meta != null && meta.hasLore()) {
                            List<String> lore = meta.getLore();
                            meta.setLore(replacePlaceholders(lore));
                            item.setItemMeta(meta);
                        }
                    }
                    return item;
                })
                .toArray(ItemStack[]::new)
        );

        entity.openInventory(clone);
    }

    private List<String> replacePlaceholders(List<String> lore) {
         return lore.stream().map(s -> s.replace("{level}", s)).collect(Collectors.toList());
    }

    @EventHandler
    public void onInvClick() {
        
    }
}