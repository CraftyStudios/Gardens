package me.pillage.garden.Enchants;

import me.pillage.garden.Events.GardenLevelHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static me.pillage.garden.Events.GardenLevelHandler.plugin;
import static me.pillage.garden.Events.GardenLevelHandler.wheatFortune;

public class WheatFortune extends Enchantment {
    private final ItemStack enchantedBook;

    public WheatFortune(NamespacedKey id, ItemStack item) {
        super(id);
        this.enchantedBook = createEnchantedBook(item);
    }

    @Override
    public String getName() {
        return Objects.requireNonNull(plugin.getConfig().getString("Wheat-Fortune-Name"));
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        List<String> items = plugin.getConfig().getStringList("Wheat-Fortune-Items");
        String itemName = ChatColor.stripColor(Objects.requireNonNull(item.getItemMeta()).getDisplayName().toLowerCase());
        return item.getType().name().contains("HOE") && items.contains(itemName);
    }

    @Override
    public int getMaxLevel() {
        return plugin.getConfig().getInt("Max-Wheat-Fortune-Level");
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TOOL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    private ItemStack createEnchantedBook(ItemStack item) {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        Enchantment wheatFortune = this;
        ItemMeta meta = book.getItemMeta();
        assert meta != null;
        meta.addEnchant(wheatFortune, 1, true);
        meta.setDisplayName(getName() + " 1");
        meta.setLore(Collections.singletonList(ChatColor.GRAY + plugin.getConfig().getString("Wheat-Fortune-Lore")));
        book.setItemMeta(meta);
        return book;
    }

    public ItemStack getEnchantedBook() {
        return enchantedBook;
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItem(event.getNewSlot());

        if (item != null) {
            WheatFortune wheatFortune = new WheatFortune(new NamespacedKey(plugin, "wheat_fortune"), item);
            if (wheatFortune.canEnchantItem(item)) {
                GardenLevelHandler.wheatFortune.put(player, item.getEnchantmentLevel(wheatFortune));
            }
        }
    }
}