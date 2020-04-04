package me.Mattq.NokwokBungee.commands.misc;

import me.Mattq.NokwokBungee.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class config extends Command {

    public config() {
        super("config");
    }

    private Main plugin = Main.getInstance();


    @Override

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED+"Player only command."));
        }

        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (p.hasPermission("Nokwok.Config")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    this.plugin.loadConfig();
                    p.sendMessage(new TextComponent(ChatColor.GRAY+"Reloaded config."));
                } else {
                    p.sendMessage(new TextComponent(ChatColor.RED+"Invalid argument: /config "+args[0]));
                }
            } else {
                p.sendMessage(new TextComponent(ChatColor.RED+"Incorrect usage: /config (reload)"));
            }
        } else {
            p.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', this.plugin.configuration.getString("noperm"))));
        }

    }
}