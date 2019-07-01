import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();

        while (n-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            firstNumbers.add(number);

        }

        while (m-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            secondNumbers.add(number);
        }

        firstNumbers.retainAll(secondNumbers);

        firstNumbers.forEach(e -> System.out.print(e + " "));
    }
}
