package me.HenRun189.snakeMCChallenge;

import me.HenRun189.snakeMCChallenge.commands.SnakeCommand;
import me.HenRun189.snakeMCChallenge.game.GameManager;
import me.HenRun189.snakeMCChallenge.listeners.PlayerMoveListener;
import me.HenRun189.snakeMCChallenge.ui.ScoreboardUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class SnakeMCChallenge extends JavaPlugin {

    private GameManager gameManager;
    private ScoreboardUI scoreboardUI;

    @Override
    public void onEnable() {
        this.gameManager = new GameManager();
        this.scoreboardUI = new ScoreboardUI(gameManager);

        // Command registrieren
        getCommand("snake").setExecutor(new SnakeCommand(gameManager));

        // Listener registrieren
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(gameManager), this);

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