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
            if (args[0].equalsIgnoreCase("Lobby1")) {
                if (!(p.getServer().getInfo().getName().equalsIgnoreCase("NokLobby1"))) {
                    p.connect(ProxyServer.getInstance().getServerInfo("NokLobby1"));
                    p.sendMessage(new TextComponent(ChatColor.GRAY + "Connecting you to: " + ChatColor.AQUA + "Lobby 1"));
                } else {
                  p.sendMessage(new TextComponent(ChatColor.RED+"You are already connected to this server!"));
                }
            } else if (args[0].equalsIgnoreCase("Smp")) {
                if (!(p.getServer().getInfo().getName().equalsIgnoreCase("NokSmp"))) {
                    p.connect(ProxyServer.getInstance().getServerInfo("NokSmp"));
                    p.sendMessage(new TextComponent(ChatColor.GRAY + "Connecting you to: " + ChatColor.AQUA + "SMP"));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"You are already connected to this server!"));
                }
            } else if (args[0].equalsIgnoreCase("Series")) {
                if (p.hasPermission("Nokwok.series")) {
                    if (!(p.getServer().getInfo().getName().equalsIgnoreCase("Series"))) {
                        p.connect(ProxyServer.getInstance().getServerInfo("Series"));
                        p.sendMessage(new TextComponent(ChatColor.GRAY + "Connecting you to: " + ChatColor.AQUA + "Series"));
                    } else {
                        p.sendMessage(new TextComponent(ChatColor.RED + "You are already connected to this server!"));
                    }
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"Insufficient Permissions!"));
                }
            } else if (args[0].equalsIgnoreCase("Lobby")) {
                if (!(p.getServer().getInfo().getName().equalsIgnoreCase("NokLobby1"))) {
                    p.connect(ProxyServer.getInstance().getServerInfo("NokLobby1"));
                    p.sendMessage(new TextComponent(ChatColor.GRAY + "Connecting you to: " + ChatColor.AQUA + "Lobby 1"));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"You are already connected to this server!"));
                }
            } else {

                p.sendMessage(new TextComponent(ChatColor.RED + "Server not found: "+args[0]));
            }
        } else {
            p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /server (server)"));
        }


    }
}