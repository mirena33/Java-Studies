import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        int counter = 1;

        while (counter++ <= times) {
            System.out.println(String.format("%d X %d = %d", number, counter, number*counter));

        }
    }
}
