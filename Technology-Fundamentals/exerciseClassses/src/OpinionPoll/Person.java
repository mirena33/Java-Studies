package OpinionPoll;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;


    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(String name){
        return this.name;
    }

    public int getAge(int age){
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s = %d", getName(name), getAge(age));
    }
}
