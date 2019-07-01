import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = "";


        while (!"end".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            if (data[0].equals("end")) {
                break;
            } else {

                switch (data[0]) {
                    case "Add":
                        numbers.add(Integer.parseInt(data[1]));
                        break;

                    case "Remove":
                        numbers.remove((Object)Integer.parseInt(data[1]));
                        break;

                    case "RemoveAt":
                        if (Integer.parseInt(data[1]) < numbers.size() && Integer.parseInt(data[1]) >= 0) {
                            numbers.remove(Integer.parseInt(data[1]));
                        }
                        break;

                    case "Insert":
                        if (Integer.parseInt(data[2]) < numbers.size() && Integer.parseInt(data[2]) >= 0) {
                            numbers.add(Integer.parseInt(data[2]), Integer.parseInt(data[1]));
                        }
                        break;
                }
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]", ""));
    }
}
