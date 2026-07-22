package me.HenRun189.snakeMCChallenge.config;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.HashMap;

public class GameConfig {

    // Mindestabstand (in Blöcken), ab dem eine Trail-Berührung als Kollision zählt
    public static final double COLLISION_DISTANCE = 0.5;

    // Wie oft (in Ticks) ein neuer Trail-Punkt gesetzt wird
    public static final int TRAIL_INTERVAL_TICKS = 2;

    // Ab wann der eigene Trail zählt
    public static final double SELF_COLLISION_IGNORE_BLOCKS = 1.5;

    // Partikel-Dichte pro Trail-Punkt
    public static final double PARTICLE_COUNT = 1;

    public static final World world = Bukkit.getWorld("world");

    public static final Material[] snakeMaterial = {};

    public static final double SNAKE_RENDER_DISTANCE = 30.0;
}