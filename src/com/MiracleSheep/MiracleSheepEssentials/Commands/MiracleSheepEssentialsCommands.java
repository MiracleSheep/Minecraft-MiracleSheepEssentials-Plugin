package com.MiracleSheep.MiracleSheepEssentials.Commands;


import com.MiracleSheep.MiracleSheepEssentials.Items.ItemManager;
import com.MiracleSheep.MiracleSheepEssentials.MiracleSheepEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;



public class MiracleSheepEssentialsCommands implements CommandExecutor {

    private final MiracleSheepEssentials main;

    public MiracleSheepEssentialsCommands(MiracleSheepEssentials main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only Players can use that command");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("rules")) {

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
            for (int i = 0 ; i < rules.length ; i ++) {
                player.sendMessage(ChatColor.GOLD + rules[i]);
            }



        }

        if (cmd.getName().equalsIgnoreCase("boom")) {

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


        if (cmd.getName().equalsIgnoreCase("saveinv")) {

            if (!sender.hasPermission("rules.all")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }



        }



        return true;
    }
}
