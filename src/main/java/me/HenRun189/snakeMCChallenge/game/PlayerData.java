package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.Material;

public class PlayerData {
    int snakeMaterialID;
    SnakePart[] lastSnakeID = new SnakePart[2];

    PlayerData(int materialID) {
        snakeMaterialID = materialID;
    }
}
