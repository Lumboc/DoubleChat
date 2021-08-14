package com.lumboc.doublechat.commands;

import com.lumboc.doublechat.DoubleChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Toggle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("dc.toggle")) {
            DoubleChat.dctoggle = !DoubleChat.dctoggle;
            sender.sendMessage(ChatColor.GREEN + "Double Chat has been toggled to " + DoubleChat.dctoggle + "!");
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
        }
        return true;
    }
}
