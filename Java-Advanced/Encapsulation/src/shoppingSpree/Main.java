package shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();


        String[] linePeople = scanner.nextLine().split(";");

        try {


            for (int i = 0; i < linePeople.length; i++) {
                String[] tokens = linePeople[i].split("=");
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                people.putIfAbsent(tokens[0], person);
            }

            String[] lineProducts = scanner.nextLine().split(";");

            for (int i = 0; i < lineProducts.length; i++) {
                String[] tokens = lineProducts[i].split("=");
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                products.putIfAbsent(tokens[0], product);
            }


            String input = "";

            while (!"END".equals(input = scanner.nextLine())) {
                String[] tokens = input.split("\\s+");

                String nameOfPerson = tokens[0];
                Product nameOfProduct = products.get(tokens[1]);

                if (people.get(nameOfPerson).validatePurchase(nameOfProduct)) {
                    people.get(nameOfPerson).buyProduct(nameOfProduct);

                    System.out.println(people.get(nameOfPerson).getName() + " bought " + nameOfProduct.getName());

                } else {
                    System.out.println(people.get(nameOfPerson).getName() + " can't afford " + nameOfProduct.getName());

                }
            }

            people.entrySet().forEach(e -> System.out.println(e.getValue().toString()));

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
