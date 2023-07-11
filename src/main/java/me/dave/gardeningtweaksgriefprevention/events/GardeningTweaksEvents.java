package me.dave.gardeningtweaksgriefprevention.events;

import me.dave.gardeningtweaks.api.events.SaplingReplantEvent;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GardeningTweaksEvents implements Listener {

    @EventHandler
    public void onSaplingReplant(SaplingReplantEvent event) {
        if (event.getPlayer() == null) {
            Claim claim = GriefPrevention.instance.dataStore.getClaimAt(event.getBlock().getLocation(), true, null);
            if (claim != null) event.setCancelled(true);
        }
    }
}
