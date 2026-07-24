package me.HenRun189.snakeMCChallenge.listeners;

import me.HenRun189.snakeMCChallenge.game.GameManager;
import me.HenRun189.snakeMCChallenge.game.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    private final GameManager gameManager;

    public PlayerRespawnListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        PlayerData pd = gameManager.getPlayerData(event.getPlayer().getUniqueId());
        if (pd != null) {
            pd.setDead(false);
        }
    }
}