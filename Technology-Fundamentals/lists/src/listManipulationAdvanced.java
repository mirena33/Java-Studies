import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {

                case "Contains":
                    if (numbers.contains(Integer.parseInt(commands[1]))) {
                        System.out.println("Yes");

                    } else {
                        System.out.println("No such number");

                    }
                    break;

                case "Print":

                    System.out.println(OddEvenSeparatedBySpace(numbers, commands[1]).trim());

                    break;

                case "Get":
                    int sum = 0;

                    for (int num : numbers) {
                        sum += num;
                    }

                    System.out.println(sum);

                    break;

                case "Filter":

                    switch (commands[1]) {

                        case "<":
                            String output0 = "";
                            for (int i = 0; i < numbers.size(); i++) {

                                if (numbers.get(i) < Integer.parseInt(commands[2])) {
                                    output0 += numbers.get(i) + " ";
                                }
                            }
                            System.out.println(output0.trim());
                            break;

                        case ">":
                            String output = "";
                            for (int i = 0; i < numbers.size(); i++) {
                                if (numbers.get(i) > Integer.parseInt(commands[2])) {
                                    output += numbers.get(i) + " ";
                                }
                            }
                            System.out.println(output.trim());


                            break;

                        case ">=":
                            String output1 = "";
                            for (int i = 0; i < numbers.size(); i++) {

                                if (numbers.get(i) >= Integer.parseInt(commands[2])) {
                                    output1 += numbers.get(i) + " ";
                                }
                            }
                            System.out.println(output1.trim());
                            break;

                        case "<=":
                            String output2 = "";
                            for (int i = 0; i < numbers.size(); i++) {

                                if (numbers.get(i) <= Integer.parseInt(commands[2])) {
                                    output2 += numbers.get(i) + " ";
                                }
                            }
                            System.out.println(output2.trim());
                            break;
                    }


                    break;
            }
            input = scanner.nextLine();
        }
    }


    static String OddEvenSeparatedBySpace(List<Integer> numbers, String command) {

        int num = command.equals("even") ? 0 : 1;
        String output = "";

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) % 2 == num) {


                output += numbers.get(i) + " ";

            }
        }

        return output;
    }
}
