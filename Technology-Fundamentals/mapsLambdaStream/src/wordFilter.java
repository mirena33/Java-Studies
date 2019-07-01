import java.util.Arrays;
        import java.util.Scanner;

public class wordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0)
                .forEach(e -> System.out.println(e));
    }
}
