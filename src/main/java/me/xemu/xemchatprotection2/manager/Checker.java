package me.xemu.xemchatprotection2.manager;

import me.xemu.xemchatprotection2.XemChatProtection2;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker
{

    public static CheckType checkMessage(final String string)
    {
        final Pattern pattern = Pattern.compile("^[\\u0000-\\u007F \\p{Sc}]*$");
        final Matcher matcher = pattern.matcher(string.toLowerCase());

        if(matcher.find())
        {
            return CheckType.UNICODE;
        };

        for (final String s : XemChatProtection2.getBlockedWords().getConfig().getStringList("blocked-words"))
        {
            if(string.toLowerCase().contains(s))
            {
                return CheckType.SWEARING;
            };
            break;
        };

        return CheckType.CLEAR;
    };

};