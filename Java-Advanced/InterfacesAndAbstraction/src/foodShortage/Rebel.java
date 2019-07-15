package foodShortage;

import foodShortage.interfaces.Buyer;
import foodShortage.interfaces.Person;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
