package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Player;
import org.bukkit.util.Transformation;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

import static me.HenRun189.snakeMCChallenge.config.GameConfig.*;

public class SnakePart {
    Location loc;
    int blockIndex;

    SnakePart(Location pLoc, int pBlockIndex) {
        loc = pLoc;
        blockIndex = pBlockIndex;
    }

    BlockDisplay displaySnake() {
        World world = loc.getWorld();
        BlockDisplay display = world.spawn(loc, BlockDisplay.class);

        display.setBlock(snakeMaterial[blockIndex].createBlockData());

        float scale = 0.25f;
        float yOffset = 0.3f; // deutlich kleiner als 0.8, sonst schwebt es zu hoch
        Transformation transformation = new Transformation(
                new Vector3f(-scale / 2, yOffset, -scale / 2), // zentriert direkt auf loc, kein Block-Offset
                new AxisAngle4f(0, 0, 0, 1),
                new Vector3f(scale, scale, scale),
                new AxisAngle4f(0, 0, 0, 1)
        );
        display.setTransformation(transformation);

        display.setPersistent(false);
        display.setBillboard(org.bukkit.entity.Display.Billboard.FIXED);

        return display;
    }

    double squareDistance(Player p) {
        return p.getLocation().distanceSquared(loc);
    }
}