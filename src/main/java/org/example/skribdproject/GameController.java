package org.example.skribdproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/join")
    public String joinGame(@RequestParam String name) {
        try {
            gameService.joinGame(name);
            return "Joined";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/api/start")
    public String startGame() {
        try {
            gameService.startGame();
            return "Started";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}