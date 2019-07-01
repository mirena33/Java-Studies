import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(commands[1]));
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    int numberToInsert = Integer.parseInt(commands[1]);

                    if (index < 0 || index >= numbers.size()) {
                        System.out.println("Invalid index");

                    } else {
                        numbers.add(index, numberToInsert);
                    }

                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(commands[1]);

                    if (indexToRemove < 0 || indexToRemove >= numbers.size()) {
                        System.out.println("Invalid index");

                    } else {
                        numbers.remove(indexToRemove);

                    }
                    break;


                case "Shift":
                    int count = Integer.parseInt(commands[2]);

                    if (numbers.size() > 0) {
                        if (commands[1].equals("left")) {

                            for (int i = 0; i < count % numbers.size(); i++) {

                                numbers.add(numbers.get(0));
                                numbers.remove(0);

                            }
                        } else {

                            for (int i = 0; i < count % numbers.size(); i++) {

                                numbers.add(0, numbers.get(numbers.size() - 1));
                                numbers.remove(numbers.size() - 1);
                            }
                        }
                        break;
                    }
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]", ""));
    }
}

