package ru.gb.lessons.interfaces.core.clients.wild.impl;

import java.time.LocalDate;

import ru.gb.lessons.interfaces.core.clients.Flyable;
import ru.gb.lessons.interfaces.core.clients.Human;
import ru.gb.lessons.interfaces.core.clients.Runnable;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.WildAnimal;

public class Duck extends WildAnimal implements Flyable, Runnable {
    private int fly_speed = 5;
    private int run_speed = 3;
    public Duck() {
    }

    public Duck(int id, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super();
    }

    @Override
    public void fly() {
        System.out.println(CLASS_NAME + "летит со скоростью: " + fly_speed +  " км/ч");
    }

    @Override
    public void run() {
        System.out.println(CLASS_NAME + "ходит со скоростью: " + run_speed +  " км/ч");
    }

    @Override
    public int getFlightSpeed() {
        return fly_speed;
    }

    @Override
    public int getRunningSpeed() {
        return run_speed;
    }

}
