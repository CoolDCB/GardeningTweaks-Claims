package me.dave.gardeningtweaksclaims.hook;

import org.bukkit.Location;

import java.util.HashMap;

public interface Hook {
    HashMap<String, Hook> hooks = new HashMap<>();

    String getId();

    boolean hasClaimAt(Location location);

    static void register(Hook hook) {
        hooks.put(hook.getId(), hook);
    }

    static void unregister(String hookId) {
        hooks.remove(hookId);
    }

    static void unregisterAll() {
        hooks.clear();
    }

    static boolean hasPrivateClaimAt(Location location) {
        for (Hook hook : hooks.values()) {
            if (hook.hasClaimAt(location)) {
                return true;
            }
        }

        return false;
    }
}
