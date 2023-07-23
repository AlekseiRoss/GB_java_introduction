package Lesson1;

public class SwimmingAnimal extends Animal {

    public SwimmingAnimal(String name, Integer age, String vaccination, String color,
            String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public SwimmingAnimal(String name) {
        this(name, null, null, null, null, null, null);
    }

    @Override
    public void toGo() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " cannot fly.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }
}
