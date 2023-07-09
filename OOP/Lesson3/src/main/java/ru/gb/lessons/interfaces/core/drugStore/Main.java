package ru.gb.lessons.interfaces.core.drugStore;

import org.w3c.dom.ls.LSSerializer;
import ru.gb.lessons.interfaces.core.clients.DoctorSpecialities;
import ru.gb.lessons.interfaces.core.personal.Doctor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static ru.gb.lessons.interfaces.core.clients.DoctorSpecialities.THERAPIST;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy1 = new Pharmacy();
        Component comp1 = new Component("Penicillin", "10 mg", 10);
        Component comp2 = new Component("Spirit", "100 g", 1000);

        pharmacy1.addComponent(comp1).addComponent(comp2);
        Pharmacy pharmacy1_copy = new Pharmacy();
        pharmacy1_copy.addComponent(comp1).addComponent(comp2);

//        Интерфейс Serializable - отвечает за сериализацию объектов. Превращает объект в массив байтов, который потом
//        можно собрать обратно при помощи десериализатора.

        List<Marker> markers = new ArrayList<>();
        Doctor doc1 = new Doctor(234, "Петрович", THERAPIST, "8(495)429-43-23");
//        markers.add().add();

        while (pharmacy1.iterator().hasNext()){
           System.out.println(pharmacy1.iterator().next());
        }

        System.out.println(pharmacy1);

//        DogPharmacy dogPharmacy = new DogPharmacy();
//        System.out.println(dogPharmacy.hashCode());
        for (Component elem : pharmacy1) {
            System.out.println(elem);
        }

        Pharmacy pharmacy2 = new Pharmacy();
        Component comp3 = new Component("Penicillin", "10 mg", 3);
        Component comp4 = new Component("Spirit", "100 g", 13);
        pharmacy2.addComponent(comp3).addComponent(comp4);
        

        Pharmacy pharmacy3 = new Pharmacy();
        Component comp5 = new Component("Penicillin", "10 mg", 12);
        Component comp6 = new Component("Spirit", "100 g", 100);
        pharmacy3.addComponent(comp5).addComponent(comp6);

        List<Pharmacy> nomenclature = new ArrayList<>();
        nomenclature.add(pharmacy3);
        nomenclature.add(pharmacy1);
        nomenclature.add(pharmacy2);

        System.out.println(nomenclature);
        Collections.sort(nomenclature);
        System.out.println("============================================================================");
        System.out.println(nomenclature);

        Set<Pharmacy> result = new HashSet<>();
        result.add(pharmacy1);
        result.add(pharmacy1_copy);
        result.add(pharmacy2);
        System.out.println(result.size());
    }
}
