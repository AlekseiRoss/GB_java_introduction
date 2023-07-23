package ru.gb.lessons.interfaces.core.clients.wild.impl;

import java.time.LocalDate;

import ru.gb.lessons.interfaces.core.Swimable;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.WildAnimal;

public class Fish extends WildAnimal implements Swimable{
    private int swim_speed = 5;

    public Fish() {
    }

    public Fish(String name) {
        super(name);
    }

    @Override
    public int getSwimmingSpeed() {
        return swim_speed;
    }

    @Override
    public String getName() {
        return this.getName();
    }
}
