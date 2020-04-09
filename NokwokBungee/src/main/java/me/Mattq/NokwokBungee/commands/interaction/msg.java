package me.Mattq.NokwokBungee.commands.interaction;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.HashMap;

public class msg extends Command {

    public HashMap<ProxiedPlayer, ProxiedPlayer> lastmsg = new HashMap<>();

    public msg() {
        super("msg");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player only command."));
        } else {
            if (args.length >= 2) {
                ProxiedPlayer p = (ProxiedPlayer) sender;
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    str.append(args[i] + " ");
                }
                String s = str.toString();


                if (target != null) {
                    lastmsg.put(p, target);

                    target.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3[MSG]&b From "+p.getName()+"&b: "+s)));
                    p.sendMessage((new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3[MSG]&b To "+target.getName()+"&b: "+s))));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"Player not found: "+args[0]));
                }
            } else {
                ProxiedPlayer p = (ProxiedPlayer) sender;
                p.sendMessage(new TextComponent(ChatColor.RED + "Incorrect usage: /msg (name) (message)"));
            }
        }
    }
}
