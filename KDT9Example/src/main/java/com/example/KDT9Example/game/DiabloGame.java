package com.example.KDT9Example.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("DIABLO")
public class DiabloGame implements GameConsole{
    public void up() {
        System.out.println("Diablo Up");
    }
    public void down() {
        System.out.println("Diablo Down");
    }
    public void right() {
        System.out.println("Diablo Right");
    }
    public void left() {
        System.out.println("Diablo Left");
    }
}
