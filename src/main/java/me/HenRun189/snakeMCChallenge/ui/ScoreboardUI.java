package me.HenRun189.snakeMCChallenge.ui;

import me.HenRun189.snakeMCChallenge.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardUI {

    private final GameManager gameManager;

    public ScoreboardUI(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void updateAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            update(player);
        }
    }

    private void update(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("snake", "dummy", ChatColor.GOLD + "Snake Challenge");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(ChatColor.GRAY + "Status: " + ChatColor.WHITE + gameManager.getState()).setScore(2);
        objective.getScore(ChatColor.GRAY + "Spieler: " + ChatColor.WHITE + gameManager.getActivePlayers().size()).setScore(1);
        // TODO: Hier weitere UI-Elemente ergänzen (z.B. Trail-Länge, Zeit, etc.)

        player.setScoreboard(board);
    }
}