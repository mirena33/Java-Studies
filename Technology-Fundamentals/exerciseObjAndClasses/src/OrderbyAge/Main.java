package OrderbyAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));

        String input = "";

        List<Person> people = new ArrayList<>();

        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String ID = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, ID, age);

            people.add(person);
        }

        people.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(e -> {
                    System.out.println(e.toString());
                });
    }
}
