package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.HenRun189.snakeMCChallenge.config.GameConfig.*;

public class SnakePart {
    Location loc;
    int blockIndex;

    SnakePart(Location pLoc, int pBlockIndex) {
        loc = pLoc;
        blockIndex = pBlockIndex;
    }

    ItemFrame displaySnake() {
        World world = loc.getWorld();
        ItemFrame frame = world.spawn(loc, ItemFrame.class);

        ItemStack item = new ItemStack(snakeMaterial[blockIndex], 1);
        frame.setItem(item);

        frame.setVisible(false);
        frame.setInvulnerable(true);
        frame.setFixed(true);

        return frame;
    }

    double squareDistance(Player p) {
        return p.getLocation().distanceSquared(loc);
    }
}