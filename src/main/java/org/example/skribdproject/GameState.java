package org.example.skribdproject;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private List<String> players;
    private boolean gameStarted;

    public GameState() {
        this.players = new ArrayList<>();
        this.gameStarted = false;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void addPlayer(String player) {
        players.add(player);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        this.gameStarted = true;
    }

    public void resetGame() {
        this.gameStarted = false;
        this.players.clear();
    }
}