package me.HenRun189.snakeMCChallenge.config;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

import static java.lang.Math.pow;

public class GameConfig {

    public static final int TRAIL_INTERVAL_TICKS = 2;
    public static final double SELF_COLLISION_IGNORE_BLOCKS = 1.5;
    public static final double PARTICLE_COUNT = 1;
    public static final World world = Bukkit.getWorld("world");

    public static final Material[] snakeMaterial = {
            Material.COAL_BLOCK,
            Material.IRON_BLOCK,
            Material.COPPER_BLOCK,
            Material.GOLD_BLOCK,
            Material.LAPIS_BLOCK,
            Material.REDSTONE_BLOCK,
            Material.DIAMOND_BLOCK,
            Material.EMERALD_BLOCK,
            Material.NETHERITE_BLOCK
    };

    public static final double SNAKE_RENDER_DISTANCE = pow(50.0, 2);

    // Kollision mit Spieler = Tod
    public static final double SNAKE_KILL_DISTANCE = pow(0.8, 2);

    // Abstand, ab dem ein neues Segment gespawnt wird (kleiner = doppelt so oft)
    public static final double SNAKE_SPAWN_DISTANCE = pow(0.08, 2);

    public static final long TICK_RATE = 4L;
}