package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        SmartList<String> list = new SmartList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    list.add(tokens[1]);
                    break;

                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;

                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;

                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;

                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;

                case "Max":
                    System.out.println(list.getMax());
                    break;

                case "Min":
                    System.out.println(list.getMin());
                    break;

                case "Sort":
                   Sorter.sort(list);
                    break;

                case "Print":
                    SmartList.printList(list);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
