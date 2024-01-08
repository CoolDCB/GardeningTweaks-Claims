package me.dave.gardeningtweaksclaims;

import me.dave.gardeningtweaksclaims.listener.GardeningTweaksListener;
import me.dave.gardeningtweaksclaims.hook.GriefPreventionHook;
import me.dave.gardeningtweaksclaims.hook.Hook;
import me.dave.gardeningtweaksclaims.hook.HuskClaimsHook;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GardeningTweaksClaims extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        if (pluginManager.getPlugin("GardeningTweaks") == null) {
            getLogger().severe("Could not find required plugin \"GardeningTweaks\". Disabling plugin.");
            setEnabled(false);
            return;
        }

        addHook("GriefPrevention", () -> Hook.register(new GriefPreventionHook()));
        addHook("HuskClaims", () -> Hook.register(new HuskClaimsHook()));

        pluginManager.registerEvents(new GardeningTweaksListener(), this);
    }

    @Override
    public void onDisable() {
        Hook.unregisterAll();
    }

    private void addHook(String pluginName, Runnable runnable) {
        PluginManager pluginManager = getServer().getPluginManager();
        if (pluginManager.getPlugin(pluginName) != null && pluginManager.getPlugin(pluginName).isEnabled()) {
            runnable.run();
            getLogger().info("Found plugin \"" + pluginName + "\". GardeningTweaks will now respect " + pluginName + " Claims.");
        }
    }
}
