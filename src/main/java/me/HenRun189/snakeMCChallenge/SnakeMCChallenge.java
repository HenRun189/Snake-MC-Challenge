package me.HenRun189.snakeMCChallenge;

import me.HenRun189.snakeMCChallenge.commands.SnakeCommand;
import me.HenRun189.snakeMCChallenge.game.GameManager;
import me.HenRun189.snakeMCChallenge.listeners.PlayerMoveListener;
import me.HenRun189.snakeMCChallenge.listeners.PlayerRespawnListener;
import me.HenRun189.snakeMCChallenge.ui.ScoreboardUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SnakeMCChallenge extends JavaPlugin {

    private GameManager gameManager;
    private ScoreboardUI scoreboardUI;

    @Override
    public void onEnable() {
        this.gameManager = new GameManager(this);
        this.scoreboardUI = new ScoreboardUI(gameManager);

        getCommand("snake").setExecutor(new SnakeCommand(gameManager));
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(gameManager), this);

        Bukkit.getScheduler().runTaskTimer(this, scoreboardUI::updateAll, 0L, 20L);

        getLogger().info("SnakeMCChallenge wurde aktiviert.");
    }

    @Override
    public void onDisable() {
        if (gameManager != null) {
            gameManager.stop();
        }
        getLogger().info("SnakeMCChallenge wurde deaktiviert.");
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public ScoreboardUI getScoreboardUI() {
        return scoreboardUI;
    }
}