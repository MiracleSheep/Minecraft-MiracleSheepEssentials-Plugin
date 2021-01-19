package com.MiracleSheep.MiracleSheepEssentials.Events;

import com.MiracleSheep.MiracleSheepEssentials.Items.ItemManager;
import com.MiracleSheep.MiracleSheepEssentials.MiracleSheepEssentials;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MiracleSheepEssentialsEvents implements Listener {

    public static MiracleSheepEssentials main;

    public MiracleSheepEssentialsEvents(MiracleSheepEssentials miracleSheepEssentials) {
        this.main = miracleSheepEssentials;

    }




    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if ( main.getConfig().getBoolean("Do_Server_Join_Message") == true) {
            player.sendMessage(ChatColor.AQUA + main.getConfig().getString("Server_Join_Message"));
        }

        if (main.getConfig().getBoolean("Do_Plugin_Announce_Message") == true) {
        player.sendMessage(ChatColor.DARK_PURPLE + "[MiracleSheepEssentials] plugin is enabled.");
        }
    }

    @EventHandler
    public static void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        if (main.getConfig().getBoolean("Do_Hospital_Bills") == true) {
            player.sendMessage(ChatColor.AQUA + main.getConfig().getString("Hospital_Death_Message"));
            player.getInventory().addItem(ItemManager.Bill);
        }

    }





}
