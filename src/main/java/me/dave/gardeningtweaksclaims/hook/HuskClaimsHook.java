package me.dave.gardeningtweaksclaims.hook;

import net.william278.huskclaims.api.BukkitHuskClaimsAPI;
import net.william278.huskclaims.libraries.cloplib.operation.Operation;
import net.william278.huskclaims.libraries.cloplib.operation.OperationType;
import org.bukkit.Location;

public class HuskClaimsHook implements Hook {

    @Override
    public String getId() {
        return "husk-claims";
    }

    @Override
    public boolean hasClaimAt(Location location) {
        BukkitHuskClaimsAPI huskClaimsAPI = BukkitHuskClaimsAPI.getInstance();
        return huskClaimsAPI.isOperationAllowed(Operation.of(OperationType.BLOCK_PLACE, huskClaimsAPI.getPosition(location)));
    }
}
