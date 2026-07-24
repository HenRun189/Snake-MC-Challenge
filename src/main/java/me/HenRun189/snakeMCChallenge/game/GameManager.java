package me.HenRun189.snakeMCChallenge.game;

import me.HenRun189.snakeMCChallenge.config.GameConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class GameManager {

    private static final Logger log = LoggerFactory.getLogger(GameManager.class);
    private final Plugin plugin;
    private GameState state = GameState.IDLE;
    private final Set<Player> activePlayers = new HashSet<>();
    ArrayList<SnakePart> snakeParts = new ArrayList<>();
    ArrayList<LoadedSnakePart> loadedSnakeParts = new ArrayList<>();
    HashMap<UUID, PlayerData> data = new HashMap<>();
    protected int taskId = -1;

    public GameManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public boolean start() {
        if (state == GameState.RUNNING) {
            return false;
        }
        if (activePlayers.isEmpty()) {
            return false;
        }
        state = GameState.RUNNING;

        int playerAmount = 0;
        for (Player p : activePlayers) {
            PlayerData pd = new PlayerData(playerAmount);
            SnakePart initialPart = new SnakePart(p.getLocation(), pd.snakeMaterialID);
            pd.lastSnakeID[0] = initialPart;
            pd.lastSnakeID[1] = initialPart;
            snakeParts.add(initialPart);
            data.put(p.getUniqueId(), pd);
            playerAmount++;
        }

        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (state != GameState.RUNNING) {
                    return;
                }

                for (Player p : activePlayers) {
                    PlayerData pd = data.get(p.getUniqueId());
                    if (pd.isDead || p.isDead()) {
                        continue;
                    }
                    for (LoadedSnakePart loadedSnakePart : loadedSnakeParts) {
                        if (loadedSnakePart.snakePart.squareDistance(p) < GameConfig.SNAKE_KILL_DISTANCE
                                && loadedSnakePart.snakePart.loc.getWorld() == p.getLocation().getWorld()) {
                            if (loadedSnakePart.snakePart != pd.lastSnakeID[0]
                                    && loadedSnakePart.snakePart != pd.lastSnakeID[1]) {
                                pd.isDead = true;
                                p.kill();
                                break;
                            }
                        }
                    }
                }

                for (Player p : activePlayers) {
                    PlayerData pd = data.get(p.getUniqueId());
                    if (pd.isDead) {
                        continue;
                    }
                    // Spawn-Abstand statt Kill-Abstand -> steuert wie oft neue Segmente entstehen
                    if (pd.lastSnakeID[0].squareDistance(p) > GameConfig.SNAKE_SPAWN_DISTANCE
                            && pd.lastSnakeID[0].loc.getWorld() == p.getLocation().getWorld()) {

                        pd.lastSnakeID[1] = pd.lastSnakeID[0];
                        pd.lastSnakeID[0] = new SnakePart(p.getLocation(), pd.snakeMaterialID);
                        snakeParts.add(pd.lastSnakeID[0]);

                        ArrayList<LoadedSnakePart> prevLoadedSnakeParts = new ArrayList<>(loadedSnakeParts);
                        loadedSnakeParts.clear();

                        for (Player p1 : activePlayers) {
                            for (SnakePart snakePart : snakeParts) {
                                if (snakePart.squareDistance(p) < GameConfig.SNAKE_RENDER_DISTANCE) {
                                    boolean containsLSP = false;
                                    for (LoadedSnakePart prevLoadedSnakePart : prevLoadedSnakeParts) {
                                        if (snakePart == prevLoadedSnakePart.snakePart) {
                                            containsLSP = true;
                                            loadedSnakeParts.add(prevLoadedSnakePart);
                                            break;
                                        }
                                    }
                                    if (!containsLSP) {
                                        LoadedSnakePart newLoadedSnakePart =
                                                new LoadedSnakePart(snakePart, snakePart.displaySnake());
                                        loadedSnakeParts.add(newLoadedSnakePart);
                                    }
                                }
                            }
                        }

                        for (LoadedSnakePart prevLoadedSnakePart : prevLoadedSnakeParts) {
                            if (!loadedSnakeParts.contains(prevLoadedSnakePart)) {
                                prevLoadedSnakePart.blockDisplay.remove();
                            }
                        }
                    }
                }
            }
        };

        taskId = runnable.runTaskTimer(plugin, 0L, GameConfig.TICK_RATE).getTaskId();

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

        for (LoadedSnakePart lsp : loadedSnakeParts) {
            lsp.blockDisplay.remove();
        }
        loadedSnakeParts.clear();
        snakeParts.clear();
        data.clear();
        activePlayers.clear();

        return true;
    }

    public boolean pause() {
        if (state != GameState.RUNNING) {
            return false;
        }
        state = GameState.PAUSED;
        return true;
    }

    public boolean resume() {
        if (state != GameState.PAUSED) {
            return false;
        }
        state = GameState.RUNNING;
        return true;
    }

    public boolean join(Player p) {
        if (state == GameState.RUNNING) {
            return false;
        }
        return activePlayers.add(p);
    }

    public boolean leave(Player p) {
        return activePlayers.remove(p);
    }

    public GameState getState() {
        return state;
    }

    public Set<Player> getActivePlayers() {
        return activePlayers;
    }

    public PlayerData getPlayerData(UUID uuid) {
        return data.get(uuid);
    }
}