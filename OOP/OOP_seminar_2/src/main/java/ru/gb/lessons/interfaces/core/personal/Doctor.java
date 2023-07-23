package ru.gb.lessons.interfaces.core.personal;

import ru.gb.lessons.interfaces.core.clients.Animals;

public class Doctor {
    public static void doOperation(Animals patients) {
        System.out.println("проведена операция над " + patients.getClassName());
    }  
}
