package me.dave.gardeningtweaksclaims.hook;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;

public class GriefPreventionHook implements Hook {

    @Override
    public String getId() {
        return "grief-prevention";
    }

    @Override
    public boolean hasClaimAt(Location location) {
        return GriefPrevention.instance.dataStore.getClaimAt(location, true, null) != null;
    }
}
