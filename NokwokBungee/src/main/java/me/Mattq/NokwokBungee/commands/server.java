package me.Mattq.NokwokBungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class server extends Command {

    public server() {
        super("server");
    }


    @Override

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 1) {
            ServerInfo target = ProxyServer.getInstance().getServerInfo(args[0]);
            if (target != null) {
                p.connect(target);
                p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3Connecting you to: &b"+target.getName())));
            } else {
                p.sendMessage(new TextComponent(ChatColor.RED + "Server not found: "+args[0]));
            }
        } else {
            p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /server (server)"));
        }
    }
}