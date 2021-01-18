package com.MiracleSheep.MiracleSheepEssentials;
import com.MiracleSheep.MiracleSheepEssentials.Commands.MiracleSheepEssentialsCommands;
import com.MiracleSheep.MiracleSheepEssentials.Events.MiracleSheepEssentialsEvents;
import com.MiracleSheep.MiracleSheepEssentials.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MiracleSheepEssentials extends JavaPlugin {


    public MiracleSheepEssentials main;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MiracleSheepEssentialsEvents(this),this);
        MiracleSheepEssentialsCommands commands = new MiracleSheepEssentialsCommands(this);
        saveDefaultConfig();
        ItemManager.init();
       getCommand("rules").setExecutor(commands);
       getCommand("boom").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MiracleSheepEssentials] plugin is enabled.");
    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MiracleSheepEssentials] plugin is disabled.");
    }


    public void saveInventory(Player player) {
        File f = new File(this.getDataFolder().getAbsolutePath(), player.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory.armor", player.getInventory().getArmorContents());
        c.set("inventory.content", player.getInventory().getContents());
        try {
            c.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreInventory(Player player) {
        File f = new File(this.getDataFolder().getAbsolutePath(), player.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        player.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        player.getInventory().setContents(content);
    }




}
