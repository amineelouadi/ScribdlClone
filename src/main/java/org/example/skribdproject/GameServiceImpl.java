package org.example.skribdproject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Service;
@Service
public class GameServiceImpl extends UnicastRemoteObject implements GameService {
    private GameState gameState;

    protected GameServiceImpl() throws RemoteException {
        gameState = new GameState();
    }

    @Override
    public void joinGame(String playerName) throws RemoteException {
        if (!gameState.isGameStarted()) {
            gameState.addPlayer(playerName);
            System.out.println(playerName + " joined the game");
        } else {
            System.out.println("Game already started. Cannot join.");
        }
    }

    @Override
    public void startGame() throws RemoteException {
        if (!gameState.isGameStarted() && !gameState.getPlayers().isEmpty()) {
            gameState.startGame();
            System.out.println("Game started with players: " + gameState.getPlayers());
        } else {
            System.out.println("Game already started or no players have joined.");
        }
    }
}