package me.dave.gardeningtweaksgriefprevention;

import me.dave.gardeningtweaksgriefprevention.events.GardeningTweaksEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GardeningTweaks_GriefPrevention extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        if (pluginManager.getPlugin("GardeningTweaks") == null) {
            getLogger().severe("Could not find required plugin \"GardeningTweaks\". Disabling plugin.");
            setEnabled(false);
            return;
        }

        if (pluginManager.getPlugin("GriefPrevention") == null) {
            getLogger().severe("Could not find required plugin \"GriefPrevention\". Disabling plugin.");
            setEnabled(false);
            return;
        }

        pluginManager.registerEvents(new GardeningTweaksEvents(), this);
    }
}
