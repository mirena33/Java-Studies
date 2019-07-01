package GenericTuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String firstLine =  scanner.nextLine();

       String name = firstLine.substring(0, firstLine.lastIndexOf(" "));

       String adderss = firstLine.substring(firstLine.lastIndexOf(" ") + 1);

       String secondLine = scanner.nextLine();

       String person = secondLine.substring(0, secondLine.indexOf(" "));
       int liters = Integer.parseInt(secondLine.substring(secondLine.indexOf(" ") + 1));

       int number = scanner.nextInt();
       double floatingPoint = scanner.nextDouble();

       Tuple<String, String> first = new Tuple<>(name, adderss);
        Tuple<String, Integer> second = new Tuple<>(person, liters);
        Tuple<Integer, Double> third = new Tuple<>(number, floatingPoint);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }
}
