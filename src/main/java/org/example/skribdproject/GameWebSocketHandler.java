package org.example.skribdproject;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameWebSocketHandler extends TextWebSocketHandler {

    private List<WebSocketSession> sessions = new ArrayList<>();
    private final GameService gameService;

    public GameWebSocketHandler(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        if (payload.startsWith("join:")) {
            String playerName = payload.substring(5);
            gameService.joinGame(playerName);
            broadcast("Player " + playerName + " has joined the game.");
        } else if (payload.startsWith("start:")) {
            gameService.startGame();
            broadcast("Game started!");
        } else if (payload.startsWith("{")) {  // Assuming JSON format for drawing data
            broadcast(payload);  // Broadcast drawing data to all clients
        }
    }

    private void broadcast(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
