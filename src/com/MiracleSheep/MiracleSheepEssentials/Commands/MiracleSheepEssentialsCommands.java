package com.MiracleSheep.MiracleSheepEssentials.Commands;


import com.MiracleSheep.MiracleSheepEssentials.Items.ItemManager;
import com.MiracleSheep.MiracleSheepEssentials.MiracleSheepEssentials;
import me.zombie_striker.psudocommands.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.UUID;


public class MiracleSheepEssentialsCommands implements CommandExecutor {

    private final MiracleSheepEssentials main;

    public MiracleSheepEssentialsCommands(MiracleSheepEssentials main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) && !(sender instanceof BlockCommandSender)) {
            sender.sendMessage("Only Players And CommandBlocks can use that command");
            return true;
        }
        CommandSender s = sender;

        if (cmd.getName().equalsIgnoreCase("rules")) {

            Player player = (Player) sender;

            if (main.getConfig().getBoolean("Do_Rules_Command") == false) {
                player.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("rules.all")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            player.sendMessage(ChatColor.GREEN + "Here are the rules:");
            String[] rules = main.getConfig().getStringList("Rules").toArray(new String[0]);
            for (int i = 0; i < rules.length; i++) {
                player.sendMessage(ChatColor.GOLD + rules[i]);
            }


        }

        if (cmd.getName().equalsIgnoreCase("boom")) {

            Player player = (Player) sender;

            if (main.getConfig().getBoolean("Do_Boom_Rod") == false) {
                player.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("boom.all")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            player.getInventory().addItem(ItemManager.BoomWand);


        }


        if (cmd.getName().equalsIgnoreCase("invsave")) {


            if (main.getConfig().getBoolean("Do_SaveLoad_Command") == false) {
                s.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("inv.all")) {
                s.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            if (args.length < 2) {
                s.sendMessage(ChatColor.DARK_RED + "Not enough arguments. Use /invsave <invname> <player>");
                return true;
            }
             if (args[1].contains("@a") || args[1].contains("@e")) {

                 s.sendMessage(ChatColor.DARK_RED + "Cannot save all players or entities");

                 return true;

             }

                Entity p =  CommandUtils.getTarget(s, args[1]);
                UUID h = p.getUniqueId();
                String hi = h.toString();
                Player pl = Bukkit.getPlayer(UUID.fromString(hi));;

                main.saveInventory(pl, args[0]);

                if (main.getConfig().getBoolean("Wipe_Upon_Save") == true) {
                    pl.getInventory().clear();
                    return true;
                }


            }



            if (cmd.getName().equalsIgnoreCase("invload")) {

                if (main.getConfig().getBoolean("Do_SaveLoad_Command") == false) {
                    s.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                    return true;
                }

                if (!sender.hasPermission("inv.all")) {
                    s.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                    return true;
                }

                if (args.length < 2) {
                    s.sendMessage(ChatColor.DARK_RED + "Not enough arguments. Use /invsave <invname> <player>");
                    return true;
                }
                try {
                Entity p =  CommandUtils.getTarget(s, args[1]);
                UUID h = p.getUniqueId();
                String hi = h.toString();
                Player pl = Bukkit.getPlayer(UUID.fromString(hi));;

                pl.getInventory().clear();
                main.loadInventory(pl, args[0]);
                } catch (Exception e) {
                    s.sendMessage(ChatColor.DARK_RED + "There is no inventory saved for this person");
                }
            }

        if (cmd.getName().equalsIgnoreCase("invloadi")) {

            if (main.getConfig().getBoolean("Do_SaveLoad_Command") == false) {
                s.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("inv.all")) {
                s.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            if (args.length < 3) {
                s.sendMessage(ChatColor.DARK_RED + "Not enough arguments. Use /invsave <invname> <player> <player>");
                return true;
            }
            try {
                Entity p =  CommandUtils.getTarget(s, args[1]);
                UUID h = p.getUniqueId();
                String hi = h.toString();
                Player pl = Bukkit.getPlayer(UUID.fromString(hi));;
                Player pls = Bukkit.getPlayerExact(args[2]);

                pls.getInventory().clear();
                main.loadInventoryi(pl, args[0], pls);
            } catch (Exception e) {
                s.sendMessage(ChatColor.DARK_RED + "There is no inventory saved for this person");
            }
        }


        if (cmd.getName().equalsIgnoreCase("invsavei")) {


            if (main.getConfig().getBoolean("Do_SaveLoad_Command") == false) {
                s.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("inv.all")) {
                s.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            if (args.length < 3) {
                s.sendMessage(ChatColor.DARK_RED + "Not enough arguments. Use /invsave <invname> <player> <player>");
                return true;
            }
            if (args[1].contains("@a") || args[1].contains("@e")) {

                s.sendMessage(ChatColor.DARK_RED + "Cannot save all players or entities");

                return true;

            }

            Entity p =  CommandUtils.getTarget(s, args[1]);
            UUID h = p.getUniqueId();
            String hi = h.toString();
            Player pl = Bukkit.getPlayer(UUID.fromString(hi));
            Player pls = Bukkit.getPlayerExact(args[2]);;


            main.saveInventoryi(pl, args[0], pls);

            if (main.getConfig().getBoolean("Wipe_Upon_Save") == true) {
                pls.getInventory().clear();
                return true;
            }


        }





            return true;
        }





}
