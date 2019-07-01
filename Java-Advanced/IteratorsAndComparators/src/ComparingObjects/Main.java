package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            Person p = new Person(tokens[0], Integer.parseInt(tokens[1]),
                    tokens[2]);

            people.add(p);

            input = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person toFind = people.get(index);

        int equalPeople = 0;

        for (Person person :
                people) {
            if (person.compareTo(toFind) == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {


            System.out.println(String.format("%d %d %d", equalPeople,
                    people.size() - equalPeople,
                    people.size()));
        }
    }
}
