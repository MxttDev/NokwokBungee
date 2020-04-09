package me.Mattq.NokwokBungee.commands.misc;

import me.Mattq.NokwokBungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.protocol.packet.Commands;

public class discord extends Command {
    public discord() {
        super("discord");
    }



    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        } else {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            String smessage = "&7Click here to join our &bDiscord&7!";
            TextComponent discordmsg = new TextComponent(ChatColor.translateAlternateColorCodes('&', smessage));
            discordmsg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/tbDapfU"));
            discordmsg.setColor(ChatColor.AQUA);
            discordmsg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").color(ChatColor.GRAY).create()));
            p.sendMessage(discordmsg);

        }
    }
}
