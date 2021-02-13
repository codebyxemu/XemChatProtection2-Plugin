package me.xemu.xemchatprotection2;

import me.xemu.xemchatprotection2.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class XemChatProtection2 extends JavaPlugin 
{

    private static XemChatProtection2 instance;

    private static final Config messages = new Config(getInstance(), "messages.yml");
    private static final Config blockedWords = new Config(getInstance(), "messages.yml");

    @Override public void onEnable()
    {
        instance = this;

        messages.saveDefaultConfig();
        blockedWords.saveDefaultConfig();

        getLogger().info("Plugin Enabled");
    };

    @Override public void onDisable() 
    {
        instance = null;

        getLogger().info("Plugin Disabled");
    };

    public static XemChatProtection2 getInstance()
    {
        return instance;
    };

    public static Config getMessages()
    {
        return messages;
    };

    public static Config getBlockedWords()
    {
        return blockedWords;
    };

};