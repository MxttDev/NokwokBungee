package me.Mattq.NokwokBungee.commands.misc;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class hub extends Command {

    public hub() {
        super("hub");
    }


    @Override

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;
        ServerInfo target = ProxyServer.getInstance().getServerInfo("Lobby1");
        if (!(target == null)) {
            p.connect(target);
            p.sendMessage(new TextComponent(ChatColor.GRAY + "Connecting you to: " + ChatColor.AQUA + "Lobby 1"));
        } else {
            p.sendMessage(new TextComponent("Lobby not found! Seek a developer!"));
        }


    }
}