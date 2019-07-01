import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] data = input.split("\\s+");

            if (data.length == 2) {
                passengers.add(Integer.parseInt(data[1]));

            } else {

                int number = Integer.parseInt(data[0]);

                for (int i = 0; i < passengers.size(); i++) {
                    int currentElement = passengers.get(i);

                    if (currentElement + number <= maxCapacity) {

                        passengers.set(i, currentElement + number);
                        break;
                    }
                }

            }
            input = scanner.nextLine();
        }

        System.out.println(passengers.toString().replaceAll("[\\[,\\]]", ""));

    }

}

