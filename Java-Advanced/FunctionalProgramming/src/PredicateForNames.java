import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = e -> e.length() <= n;

        Arrays.stream(words).filter(predicate)
                .forEach(System.out::println);
    }
}
