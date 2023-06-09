package me.pillage.garden.Enchants;

import me.pillage.garden.Events.GardenEventHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static me.pillage.garden.Events.GardenEventHandler.plugin;

public class WheatFortune extends Enchantment implements Listener {
    private final ItemStack enchantedBook;
    static NamespacedKey recipeKey = new NamespacedKey(plugin, "wheat_fortune_recipe");
    ShapedRecipe recipe;

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

    private ItemStack createEnchantedBook(ItemStack wheatFortuneBook) {
        Enchantment wheatFortune = this;
        ItemMeta meta = wheatFortuneBook.getItemMeta();
        assert meta != null;
        meta.addEnchant(wheatFortune, 1, true);
        meta.setDisplayName(getName() + " 1");
        meta.setLore(Collections.singletonList(ChatColor.GRAY + plugin.getConfig().getString("Wheat-Fortune-Lore")));
        wheatFortuneBook.setItemMeta(meta);
        return wheatFortuneBook;
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
                GardenEventHandler.wheatFortune.put(player, item.getEnchantmentLevel(wheatFortune));
            }
        }
    }

    public static ShapedRecipe createRecipe(ItemStack book) {
        ShapedRecipe recipe = new ShapedRecipe(recipeKey, book);
        recipe.shape("___", "_PP", "_PW");
        recipe.setIngredient('P', new RecipeChoice.ExactChoice(new ItemStack(Material.PAPER, 16)));
        recipe.setIngredient('W', new RecipeChoice.ExactChoice(new ItemStack(Material.WHEAT, 64)));
        return recipe;
    }
}