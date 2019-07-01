import java.util.Scanner;

public class divideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 0; i < num; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber % 2 == 0) {
                p1++;
            } if (currentNumber % 3 == 0) {
                p2++;
            } if (currentNumber % 4 == 0) {
                p3++;
            }
        }

        System.out.printf("%.2f%%%n", p1 / num * 100);
        System.out.printf("%.2f%%%n", p2 / num * 100);
        System.out.printf("%.2f%%%n", p3 / num * 100);
    }
}
