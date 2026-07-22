package me.HenRun189.snakeMCChallenge.listeners;

import me.HenRun189.snakeMCChallenge.game.GameManager;
import me.HenRun189.snakeMCChallenge.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private final GameManager gameManager;

    public PlayerMoveListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (gameManager.getState() != GameState.RUNNING) {
            return;
        }
        // TODO: Hier programmierst DU deine Trail-Logik & Kollisionserkennung
        // z.B. gameManager.checkTrailCollision(event.getPlayer(), event.getTo());
    }
}