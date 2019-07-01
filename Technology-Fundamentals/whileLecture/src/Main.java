import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in the range [1...100]: ");
        int number = Integer.parseInt(scanner.nextLine());

        while (!(number >= 1 && number <= 100)) { // (n < 1 || n > 100)
            System.out.println("Invalid number!");
            System.out.print("Enter a number in the range [1...100]: ");
            number = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The number is: " + number);

    }
}
