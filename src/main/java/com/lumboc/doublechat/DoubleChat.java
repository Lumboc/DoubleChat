package com.lumboc.doublechat;

import com.lumboc.doublechat.commands.Toggle;
import com.lumboc.doublechat.events.DoubleChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoubleChat extends JavaPlugin {

    private static DoubleChat instance;

    public static boolean dctoggle = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        System.out.println("Double Chat - Starting Up!");
        getServer().getPluginManager().registerEvents(new DoubleChatEvent(), this);
        Bukkit.getPluginCommand("dctoggle").setExecutor(new Toggle());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Double Chat - shutting down!");
    }

    public static DoubleChat getInstance() {
        return instance;
    }

}