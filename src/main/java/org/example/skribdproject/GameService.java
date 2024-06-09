package org.example.skribdproject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameService extends Remote {
    void joinGame(String playerName) throws RemoteException;
    void startGame() throws RemoteException;
}
