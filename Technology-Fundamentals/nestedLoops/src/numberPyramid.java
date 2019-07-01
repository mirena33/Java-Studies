import java.util.Scanner;

public class numberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                counter++;
                System.out.printf("%d ", counter);
                if (counter == number) {
                    return;
                }
            }
            System.out.println();
        }
    }
}
