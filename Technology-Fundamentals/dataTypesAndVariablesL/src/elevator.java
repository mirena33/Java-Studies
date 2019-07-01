import java.util.Scanner;

public class elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double people = Double.parseDouble(scanner.nextLine());
        double capacity = Double.parseDouble(scanner.nextLine());

        double result = /* or (int) */ Math.ceil(people / capacity);

        System.out.printf("%.0f", result);
    }
}
