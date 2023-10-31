package com.example.KDT9Example.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameEngine {
    private GameConsole game;

    public GameEngine( @Qualifier("DIABLO") GameConsole game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
