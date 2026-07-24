package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.entity.BlockDisplay;

public class LoadedSnakePart {
    SnakePart snakePart;
    BlockDisplay blockDisplay;

    LoadedSnakePart(SnakePart pSnakePart, BlockDisplay pBlockDisplay) {
        snakePart = pSnakePart;
        blockDisplay = pBlockDisplay;
    }
}