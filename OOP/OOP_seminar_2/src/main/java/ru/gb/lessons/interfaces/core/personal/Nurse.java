package ru.gb.lessons.interfaces.core.personal;

import ru.gb.lessons.interfaces.core.clients.Animals;

public class Nurse {
    public static void doInjection(Animals patients) {
        System.out.println("сделан укол " + patients.getClassName());
    }  
}
