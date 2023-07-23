package ru.gb.lessons.interfaces.core.drugStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Marker {
    private List<Component> components;
    private int componentsCount;
    private int index;

    public Pharmacy() {
        this.components = new ArrayList<>();
        this.componentsCount = 0;
        this.index = 0;
    }
    public Pharmacy addComponent (Component component) {
        this.components.add(component);
        this.componentsCount++;
        return this;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", count=" + componentsCount +
                '}'+"Total power = "+getPower(this)+"\n";
    }

    @Override
    public Iterator<Component> iterator() {
       return new Iterator<Component>() { //Анонимный класс
            public Component next() {
                return components.get(index++);
            }

            public boolean hasNext() {
                if (index == components.size()){
                    index = 0;
                    return false;
                }
                return index < components.size();
            }
       };
//        return new ComponentIterator();
    }

    @Override
    public int compareTo(Pharmacy o) {
        int pow1 = getPower(this);
        int pow2 = getPower(o);
        if (pow1 != pow2) {
            return Integer.compare(pow1, pow2);
        } else {
            List<Component> components1 = getComponents();
            List<Component> components2 = o.getComponents();
            if (components1.size() != components2.size()) {
                return Integer.compare(components1.size(), components2.size());
            } else {
                for (int i = 0; i < components1.size(); i++) {
                    Component c1 = components1.get(i);
                    Component c2 = components2.get(i);
                    int cmp = c1.getName().compareTo(c2.getName());
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        // Первое условие if (this == o) return true; проверяет, является ли объект o ссылкой на текущий объект this. Если это так, то оба объекта считаются равными, и метод возвращает true. Это проверка выполняется для оптимизации и быстрого исключения случая, когда сравниваются две ссылки на один и тот же объект. 
        if (this == o) return true;
        // Второе условие if (o == null || getClass() != o.getClass()) return false; проверяет, является ли объект o null или принадлежит ли он к другому классу, отличному от класса Pharmacy. Если хотя бы одно из этих условий выполняется, то объекты не могут быть равными, и метод возвращает false.
        if (o == null || getClass() != o.getClass()) return false;
        // Если оба условия не выполняются, то следующей строкой создается временная переменная pharmacy типа Pharmacy, в которую приводится объект o (предполагается, что объект o является экземпляром класса Pharmacy).
        Pharmacy pharmacy = (Pharmacy) o;
        // Метод Objects.equals() сравнивает два объекта на равенство, учитывая возможность, что один или оба объекта могут быть null. В данном случае, сравниваются списки components текущего объекта и объекта pharmacy. Если списки равны (содержат одни и те же компоненты в одном и том же порядке или оба null), то метод возвращает true, указывая на равенство объектов Pharmacy.
        return Objects.equals(components, pharmacy.components);
    }

    // Генерирует хэш-код на основе списка компонентов components текущего объекта Pharmacy. Метод Objects.hash() принимает переменное количество аргументов и вычисляет хэш-код на основе значений этих аргументов. В данном случае, передается только один аргумент - список components.
    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    private int getPower (Pharmacy pharm) {
        int result = 0;
        for (Component elem: pharm.getComponents()) {
            result += elem.getPower();
        }
        return result;
    }
}
