package me.xemu.xemchatprotection2.events;

import me.xemu.xemchatprotection2.XemChatProtection2;
import me.xemu.xemchatprotection2.manager.CheckType;
import me.xemu.xemchatprotection2.manager.Checker;
import me.xemu.xemchatprotection2.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener
{

    @EventHandler protected void onChat(final AsyncPlayerChatEvent event)
    {
        final String string = event.getMessage().toLowerCase();

        if(Checker.checkMessage(string) == CheckType.CLEAR)
        {
            return;
        } else if (Checker.checkMessage(string) == CheckType.ADVERTISING)
        {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Utils.colorize(XemChatProtection2.getMessages().getConfig().getString("BlockedMessage.Advertising").replaceAll("<message>", string).replaceAll("<player>", event.getPlayer().getName())));
            return;
        } else if (Checker.checkMessage(string) == CheckType.SWEARING) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Utils.colorize(XemChatProtection2.getMessages().getConfig().getString("BlockedMessage.Swearing").replaceAll("<message>", string).replaceAll("<player>", event.getPlayer().getName())));
        } else if (Checker.checkMessage(string) == CheckType.UNICODE) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(Utils.colorize(XemChatProtection2.getMessages().getConfig().getString("BlockedMessage.Unicode").replaceAll("<message>", string).replaceAll("<player>", event.getPlayer().getName())));
        } else {
            return;
        };

    };

};