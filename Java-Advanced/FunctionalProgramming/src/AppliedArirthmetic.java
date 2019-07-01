import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArirthmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Consumer<ArrayList<Integer>> printer =
                arr -> arr.forEach(num -> System.out.print(num + " "));

        Function<ArrayList<Integer>, ArrayList<Integer>> increment =
                list -> list.stream().map(e -> ++e).collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> byTwo =
                list -> list.stream().map(e -> e *= 2).collect(Collectors.toCollection(ArrayList::new));


        UnaryOperator<ArrayList<Integer>> subtract =
                list -> list.stream().map(e -> e -= 1).collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        while (!"end".equals(command)) {

            switch (command) {
                case "add":
                    numbers = increment.apply(numbers);
                    break;

                case "multiply":
                    numbers = byTwo.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;

                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
