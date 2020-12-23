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
            if (!sender.hasPermission("rules.all")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            player.sendMessage(ChatColor.GREEN + "Here are the rules:");
            player.sendMessage(ChatColor.GOLD + "Be a good child.");
            player.sendMessage(ChatColor.GOLD + "Don't grief people's stuff, but killing is allowed.");
            player.sendMessage(ChatColor.GOLD + "Don't steal people's services and items, you must buy them or trade them");
            player.sendMessage(ChatColor.GOLD + "No Hacking");
            player.sendMessage(ChatColor.GOLD + "No Exploiting bugs(duping, ect)");
            player.sendMessage(ChatColor.GOLD + "Must refer to server owner as the coolest and awesomest person");
            player.sendMessage(ChatColor.GOLD + "That's it! Have fun!");
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
