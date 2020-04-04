package me.Mattq.NokwokBungee.commands;

import me.Mattq.NokwokBungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class staffchat extends Command {

    public staffchat() {
        super("s");
    }

    private Main plugin = Main.getInstance();

    @Override

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }


        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length >= 1) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                str.append(args[i] + " ");
            }
            String msg = str.toString();
            String format = this.plugin.configuration.getString("staffchat");


            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                if (player.hasPermission("Nokwok.staff")) {
                    player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', format.replace("<player>", p.getName()).replace("<message>", msg))));
                }
            }

        } else {
            p.sendMessage(new TextComponent(ChatColor.RED+"Incorrect usage: /s (message)"));
        }

    }
}