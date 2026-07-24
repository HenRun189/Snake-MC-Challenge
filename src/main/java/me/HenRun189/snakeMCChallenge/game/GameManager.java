package me.HenRun189.snakeMCChallenge.game;

import me.HenRun189.snakeMCChallenge.config.GameConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import java.util.*;

public class GameManager {

    private GameState state = GameState.IDLE;
    private final Set<Player> activePlayers = new HashSet<>();
    ArrayList<SnakePart> snakeParts = new ArrayList<>();
    ArrayList<LoadedSnakePart> loadedSnakeParts = new ArrayList<>();
    HashMap<UUID, PlayerData> data = new HashMap<>();
    protected int taskId = -1;

    public boolean start() {

        // data.put(p.getUniqueId(), new PlayerData(p.getUniqueId()));
        if (state == GameState.RUNNING) {
            return false;
        }
        state = GameState.RUNNING;

        int playerAmount = 0;
        for (Player p : activePlayers) {
            data.put(p.getUniqueId(), new PlayerData(playerAmount));
            playerAmount++;
        }

        new BukkitRunnable() {

            @Override
            public void run() {

                 if (state == GameState.RUNNING) {
                     for (Player p : activePlayers) {
                         for (LoadedSnakePart loadedSnakePart : loadedSnakeParts) {
                             if (loadedSnakePart.snakePart.squareDistance(p) < GameConfig.SNAKE_KILL_DISTANCE && loadedSnakePart.snakePart.loc.getWorld() == p.getLocation().getWorld()) {
                                 if (loadedSnakePart.snakePart != data.get(p.getUniqueId()).lastSnakeID[0] &&
                                         loadedSnakePart.snakePart != data.get(p.getUniqueId()).lastSnakeID[1]) {

                                     p.kill();
                                 }
                             }
                         }
                     }

                     for (Player p : activePlayers) {
                         if (data.get(p.getUniqueId()).lastSnakeID[0].squareDistance(p) > GameConfig.SNAKE_KILL_DISTANCE && data.get(p.getUniqueId()).lastSnakeID[0].loc.getWorld() == p.getLocation().getWorld()) {

                             data.get(p.getUniqueId()).lastSnakeID[1] = data.get(p.getUniqueId()).lastSnakeID[0];
                             data.get(p.getUniqueId()).lastSnakeID[0] = new SnakePart(p.getLocation(), data.get(p.getUniqueId()).snakeMaterialID);
                             snakeParts.add(data.get(p.getUniqueId()).lastSnakeID[0]);

                             ArrayList<LoadedSnakePart> prevLoadedSnakeParts = new ArrayList<LoadedSnakePart>(loadedSnakeParts);
                             loadedSnakeParts.clear();

                             for (SnakePart snakePart : snakeParts) {
                                 if (snakePart.squareDistance(p) < GameConfig.SNAKE_RENDER_DISTANCE) {
                                     boolean containsLSP = false;

                                     for (LoadedSnakePart prevLoadedSnakePart : prevLoadedSnakeParts) {
                                         if (snakePart == prevLoadedSnakePart.snakePart) {
                                             containsLSP = true;
                                             break;
                                         }
                                     }
                                     if (!containsLSP) {
                                         LoadedSnakePart newLoadedSnakePart = new LoadedSnakePart(snakePart, snakePart.displaySnake());
                                     }
                                 }
                             }

                             for (LoadedSnakePart prevLoadedSnakePart : prevLoadedSnakeParts) {
                                 boolean containsLSP = false;

                                 for (LoadedSnakePart loadedSnakePart : loadedSnakeParts) {
                                     if (loadedSnakePart == prevLoadedSnakePart) {
                                         containsLSP = true;
                                         break;
                                     }
                                 }
                                 if (!containsLSP) {
                                     prevLoadedSnakePart.itemFrame.remove();
                                     loadedSnakeParts.remove(prevLoadedSnakePart);
                                     prevLoadedSnakeParts.remove(prevLoadedSnakePart);
                                 }
                             }
                         }
                     }
                 }
            }
        };

        return true;
    }

    public boolean stop() {
        if (taskId != -1) {
            Bukkit.getScheduler().cancelTask(taskId);
            taskId = -1;
        }
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