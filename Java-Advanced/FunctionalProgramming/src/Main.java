import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // SORT EVEN NUMBERS

        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

       evenNumbers.sort(Integer::compare);

       List<String> evenSorted =
               evenNumbers.stream()
               .map(String::valueOf)
               .collect(Collectors.toList());

        System.out.println(String.join(", ", evenSorted));
    }
}
