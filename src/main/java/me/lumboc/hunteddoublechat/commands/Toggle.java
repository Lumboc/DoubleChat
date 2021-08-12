package me.lumboc.hunteddoublechat.commands;

import me.lumboc.hunteddoublechat.LumbocDoubleChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Toggle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("hdc.toggle")) {
            LumbocDoubleChat.hdctoggle = !LumbocDoubleChat.hdctoggle;
            sender.sendMessage(ChatColor.GREEN + "HDC has been toggled to " + LumbocDoubleChat.hdctoggle + "!");
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
        }
        return true;
    }
}
