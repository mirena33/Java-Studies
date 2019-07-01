import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split(", ");

        Function<String, Integer> parse = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(split)
                .map(parse)
                .collect(Collectors.toList());

        System.out.printf("Count = %d\n", numbers.size());

        int sum = numbers
                .stream()
                .reduce(0, (a, b) -> a + b);

        System.out.printf("Sum = %d", sum);

    }
}
