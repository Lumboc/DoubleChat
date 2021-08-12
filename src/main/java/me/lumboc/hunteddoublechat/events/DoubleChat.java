package me.lumboc.hunteddoublechat.events;

import me.lumboc.hunteddoublechat.LumbocDoubleChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class DoubleChat implements Listener {

    private final List<String> teamA = LumbocDoubleChat.getInstance().getConfig().getStringList("TeamA");

    private final List<String> teamB = LumbocDoubleChat.getInstance().getConfig().getStringList("TeamB");

    @EventHandler

    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        if (LumbocDoubleChat.hdctoggle) {
            if(this.teamA.contains(event.getPlayer().getName())) // The person sending the message is on Team A, remove all TeamB from receiving
            {
                event.getRecipients().removeIf(player -> this.teamB.contains(player.getName()));
            } else if(this.teamB.contains(event.getPlayer().getName())) // The person sending the message is on Team B, remove all TeamA from receiving
            {
                event.getRecipients().removeIf(player -> this.teamA.contains(player.getName()));
            }
        }
    }

}