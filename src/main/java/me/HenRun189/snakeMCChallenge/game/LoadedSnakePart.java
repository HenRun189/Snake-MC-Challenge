package me.HenRun189.snakeMCChallenge.game;

import org.bukkit.entity.ItemFrame;

public class LoadedSnakePart {
    SnakePart snakePart;
    ItemFrame itemFrame;

    LoadedSnakePart(SnakePart pSnakePart, ItemFrame pItemFrame) {
        snakePart = pSnakePart;
        itemFrame = pItemFrame;
    }
}
