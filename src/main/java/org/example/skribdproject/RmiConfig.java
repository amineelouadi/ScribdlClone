package org.example.skribdproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

@Configuration
public class RmiConfig {

    @Bean
    public GameService gameService() throws Exception {
        LocateRegistry.createRegistry(1099);
        GameService gameService = new GameServiceImpl();
        Naming.rebind("rmi://localhost/GameService", gameService);
        return gameService;
    }
}