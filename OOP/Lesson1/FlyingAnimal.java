package Lesson1;

public class FlyingAnimal extends Animal {

    public FlyingAnimal(String name, Integer age, String vaccination, String color,
            String species, Owner owner, Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);
    }

    public FlyingAnimal(String name) {
        this(name, null, null, null, null, null, null);
    }

    @Override
    public void toGo() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " cannot swim.");
    }
}
