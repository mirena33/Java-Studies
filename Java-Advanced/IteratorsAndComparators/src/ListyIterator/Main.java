package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListIteratory iterator = new ListIteratory(list);

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            switch (line) {
                case "Move":
                    System.out.println(iterator.move());
                    break;

                case "Print":
                    try {
                        System.out.println(iterator.print());
                    } catch (IllegalAccessException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;

                case "PrintAll":
                    iterator.PrintAll();
                    System.out.println();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
