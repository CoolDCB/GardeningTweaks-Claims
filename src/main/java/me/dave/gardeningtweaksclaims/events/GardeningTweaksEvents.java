package me.dave.gardeningtweaksclaims.events;

import me.dave.gardeningtweaks.api.events.SaplingReplantEvent;
import me.dave.gardeningtweaksclaims.hook.Hook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GardeningTweaksEvents implements Listener {

    @EventHandler
    public void onSaplingReplant(SaplingReplantEvent event) {
        if (event.getPlayer() == null && Hook.hasPrivateClaimAt(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }
}
