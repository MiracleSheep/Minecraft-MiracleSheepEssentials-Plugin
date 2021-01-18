package com.MiracleSheep.MiracleSheepEssentials.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack BoomWand;
    public static ItemStack Bill;
    public static void init() {
        createBill();
        createWand();
    }



    private static void createWand() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4BOOMROD");
        List<String> lore = new ArrayList<>();
        lore.add("§bMakes things go boom!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        BoomWand = item;
    }

        private static void createBill() {
        ItemStack item = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4Hospital Bill");
        List<String> lore = new ArrayList<>();
        lore.add("§bPlz pay 50000 diamonds");
        lore.add("§bfor hospital costs");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK,10,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Bill = item;

    }
}
