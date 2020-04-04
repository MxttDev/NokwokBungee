package me.Mattq.NokwokBungee.Events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;

public class join implements Listener {

    public void onPostLogin(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (p.getServer().getInfo().getName().equalsIgnoreCase("staff-build")) {
            //IDK YET
        }
    }
}
