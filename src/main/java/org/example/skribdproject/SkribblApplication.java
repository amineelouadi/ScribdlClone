package org.example.skribdproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

@SpringBootApplication
public class SkribblApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SkribblApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/GameService", new GameServiceImpl());
            System.out.println("GameService is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}