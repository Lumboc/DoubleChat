package com.lumboc.doublechat.events;

import com.lumboc.doublechat.DoubleChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class DoubleChatEvent implements Listener {

    private final List<String> teamA = DoubleChat.getInstance().getConfig().getStringList("TeamA");

    private final List<String> teamB = DoubleChat.getInstance().getConfig().getStringList("TeamB");

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        if (DoubleChat.dctoggle) {
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