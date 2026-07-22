package me.HenRun189.snakeMCChallenge.config;

public class GameConfig {

    // Mindestabstand (in Blöcken), ab dem eine Trail-Berührung als Kollision zählt
    public static final double COLLISION_DISTANCE = 0.5;

    // Wie oft (in Ticks) ein neuer Trail-Punkt gesetzt wird
    public static final int TRAIL_INTERVAL_TICKS = 2;

    // Wie lange ein Trail-Punkt sichtbar bleibt (in Sekunden), 0 = unendlich
    public static final int TRAIL_LIFETIME_SECONDS = 0;

    // Ab wann der eigene Trail zählt
    public static final double SELF_COLLISION_IGNORE_BLOCKS = 1.5;

    // Partikel-Dichte pro Trail-Punkt
    public static final double PARTICLE_COUNT = 1;
}