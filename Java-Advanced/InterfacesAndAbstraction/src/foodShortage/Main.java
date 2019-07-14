package foodShortage;

import foodShortage.interfaces.Buyer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];

                Buyer citizen = new Citizen(name, age, id, birthDate);
                people.putIfAbsent(name, citizen);


            } else if (data.length == 3) {
                String group = data[2];

                Buyer rebel = new Rebel(name, age, group);
                people.putIfAbsent(name, rebel);


            }
        }

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            if (people.containsKey(input)) {
                people.get(input).buyFood();
            }
        }

        int[] totalFood = new int[1];

      people.entrySet().forEach(person -> {
          totalFood[0] += person.getValue().getFood();
      });

        System.out.println(totalFood[0]);
    }
}
