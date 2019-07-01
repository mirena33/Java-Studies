import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class changeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Delete":
                    numbers.removeIf(n -> n.equals(commands[1]));
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    String number = commands[1];

                    if (index < 0 || index >= numbers.size()){
                        break;

                    } else {
                        numbers.add(index, number);
                        break;
                    }
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]", ""));
    }
}

