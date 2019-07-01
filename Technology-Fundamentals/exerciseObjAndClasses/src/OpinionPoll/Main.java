package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                        (new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);

            people.add(person);

        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))     // (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())      ako sravnqvahme po godini
                .forEach(e -> {
                    System.out.println(e.toString());
                });

    }
}
