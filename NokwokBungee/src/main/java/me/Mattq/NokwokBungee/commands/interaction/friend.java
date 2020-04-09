package me.Mattq.NokwokBungee.commands.interaction;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class friend extends Command {

    public friend() {
        super("friend");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        } else {
            if (args.length == 2) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if (args[0].equalsIgnoreCase("add")) {

                }
            }
        }
    }
}
