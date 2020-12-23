package com.MiracleSheep.MiracleSheepEssentials.Events;

import com.MiracleSheep.MiracleSheepEssentials.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MiracleSheepEssentialsEvents implements Listener {


    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.AQUA + "Welcome to MiracleSheep's server!");
        player.sendMessage(ChatColor.DARK_PURPLE + "[MiracleSheepEssentials] plugin is enabled.");

    }

    @EventHandler
    public static void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.AQUA + "You are now a dummydum. Shame on you.");
        player.getInventory().addItem(ItemManager.Bill);

    }





}
