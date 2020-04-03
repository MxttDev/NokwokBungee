package me.Mattq.NokwokBungee;

import me.Mattq.NokwokBungee.commands.server;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    @Override
    public void onEnable() {
        getLogger().info("[BUNGEECORD] Loaded");
        SetupCmds();
    }

    private void SetupCmds() {
        getProxy().getPluginManager().registerCommand(this, new server()); // /SERVER (NAME)
    }
}
