package me.Mattq.NokwokBungee;

import com.google.common.io.ByteStreams;
import me.Mattq.NokwokBungee.Events.join;
import me.Mattq.NokwokBungee.commands.misc.config;
import me.Mattq.NokwokBungee.commands.server;
import me.Mattq.NokwokBungee.commands.staffchat;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;

public class Main extends Plugin {


    public Configuration configuration;
    private static Main instance;
    private File file;

    @Override
    public void onEnable() {


        setInstance(this);
        getLogger().info("[BUNGEECORD] Loaded");
        SetupCmds();
        SetupEvents();

        loadConfig();

        String test = this.configuration.getString("lol");
        getLogger().info(test);
    }

    private void SetupEvents() {
        getProxy().getPluginManager().registerListener(this, new join());
    }

    private void SetupCmds() {
        getProxy().getPluginManager().registerCommand(this, new server()); // /SERVER (NAME)
        getProxy().getPluginManager().registerCommand(this, new staffchat()); // /S (MESSAGE)
        getProxy().getPluginManager().registerCommand(this, new config()); // /CONFIG (RELOAD)
    }


    public void loadConfig() {
        file = new File(ProxyServer.getInstance().getPluginsFolder(), "config.yml");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            this.saveConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }
}
