package me.Mattq.NokwokBungee.commands.interaction;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class find extends Command {

    public find() {
        super("find");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        } else {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (args.length == 1) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if (target != null) {

                    p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&b"+target.getName()+" Is currently connected to "+target.getServer().getInfo().getName())));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"Player not found: "+args[0]));
                }
            } else {
                p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /find (name)"));
            }
        }
    }
}
