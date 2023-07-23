package ru.gb.lessons.interfaces.core;

import java.util.ArrayList;
import java.util.List;

import ru.gb.lessons.interfaces.core.clients.Animal;
import ru.gb.lessons.interfaces.core.clients.Animals;
import ru.gb.lessons.interfaces.core.clients.Flyable;
import ru.gb.lessons.interfaces.core.clients.Human;
import ru.gb.lessons.interfaces.core.clients.home.impl.Cat;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Duck;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Fish;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Turtle;
import ru.gb.lessons.interfaces.core.personal.Doctor;
import ru.gb.lessons.interfaces.core.personal.Nurse;

public class VetClinic {
    private static List<Animals> animals = new ArrayList<>();

    private List<Runnable> runners = new ArrayList<>();
    private static List<Swimable> swimmers = new ArrayList<>();
    private List<Soundable> sounders = new ArrayList<>();
    private List<Flyable> flyers = new ArrayList<>();

    public static void main(String[] args) {
        Human human = new Human("Пайтон");
        Cat cat = new Cat(0, null, 0, null, null);
        // animals.add(human);
        animals.add(cat);
        for (Animals element: animals) {
            heal(element);
        }
        Turtle turtle = new Turtle("Turtle");
        System.out.println(turtle.getSwimmingSpeed());
        Doctor.doOperation(turtle);
        Nurse.doInjection(turtle);
        Fish fish = new Fish("fish");
        addSwimmer(turtle);
        addSwimmer(fish);
        for (Swimable swimmer: swimmers) {
            System.out.println(swimmer.getSwimmingSpeed());
        }
    }

    public void addRunner(Runnable runner) {
        runners.add(runner);
    }

    public static void addSwimmer(Swimable swimmer) {
        swimmers.add(swimmer);
    }

    public void addSounder(Soundable sounder) {
        sounders.add(sounder);
    }

    public void addFlyer(Flyable flyer) {
        flyers.add(flyer);
    }

    public List<Runnable> getAllRunners() {
        return runners;
    }

    public List<Swimable> getAllSwimmers() {
        return swimmers;
    }

    public List<Soundable> getAllSounders() {
        return sounders;
    }

    public List<Flyable> getAllFlyers() {
        return flyers;
    }

    private static void heal(Animals patients) {
        System.out.println(patients.getClassName() + " вылечен");
    }  
}

