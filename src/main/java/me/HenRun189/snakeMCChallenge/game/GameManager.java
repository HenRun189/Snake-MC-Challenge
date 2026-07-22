package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private GameState state = GameState.IDLE;
    private final Set<Player> activePlayers = new HashSet<>();
    private

    boolean start() {
        if (state == GameState.RUNNING) {
            return false;
        }
        state = GameState.RUNNING;

        return true;
    }

    public boolean stop() {
        if (state == GameState.IDLE) {
            return false;
        }
        state = GameState.IDLE;
        activePlayers.clear();
        // TODO: Hier deine Aufräum-Logik (Trails entfernen, Spieler zurücksetzen)
        return true;
    }

    public boolean pause() {
        if (state != GameState.RUNNING) {
            return false;
        }
        state = GameState.PAUSED;
        // TODO: Hier deine Pause-Logik (Ticks stoppen etc.)
        return true;
    }

    public boolean resume() {
        if (state != GameState.PAUSED) {
            return false;
        }
        state = GameState.RUNNING;
        // TODO: Hier deine Resume-Logik
        return true;
    }

    public GameState getState() {
        return state;
    }

    public Set<Player> getActivePlayers() {
        return activePlayers;
    }
}