package me.lumboc.hunteddoublechat;

import me.lumboc.hunteddoublechat.commands.Toggle;
import me.lumboc.hunteddoublechat.events.DoubleChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LumbocDoubleChat extends JavaPlugin {

    private static LumbocDoubleChat instance;

    public static boolean hdctoggle = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        System.out.println("Lumboc Double Chat - Starting Up!");
        getServer().getPluginManager().registerEvents(new DoubleChat(), this);
        Bukkit.getPluginCommand("hdctoggle").setExecutor(new Toggle());
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Hunted Double Chat - shutting down!");
    }

    public static LumbocDoubleChat getInstance() {
        return instance;
    }

}
