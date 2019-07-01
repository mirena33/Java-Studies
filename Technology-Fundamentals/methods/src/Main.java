import java.util.Scanner;

public class Main {

    public static void printSign(int n) {

        if (n < 0) {
            System.out.printf("The number %d is negative.", n);
        } else if (n > 0) {
            System.out.printf("The number %d is positive.", n);
        } else {
            System.out.printf("The number %d is zero.", n);
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printSign(Integer.parseInt(scanner.nextLine()));


    }
}
