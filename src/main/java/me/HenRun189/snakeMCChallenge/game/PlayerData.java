package me.HenRun189.snakeMCChallenge.game;

public class PlayerData {
    int snakeMaterialID;
    SnakePart[] lastSnakeID = new SnakePart[2];
    boolean isDead = false;

    PlayerData(int materialID) {
        snakeMaterialID = materialID;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }
}