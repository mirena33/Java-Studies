import java.util.Scanner;

public class histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 0; i < numbers; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber < 200) {
                p1++;
            } else if (currentNumber < 400) {
                p2++;
            } else if (currentNumber < 600) {
                p3++;
            } else if (currentNumber < 800) {
                p4++;
            } else {
                p5++;
            }

        }

        System.out.printf("%.2f%%%n", p1 / numbers * 100);
        System.out.printf("%.2f%%%n", p2 / numbers * 100);
        System.out.printf("%.2f%%%n", p3 / numbers * 100);
        System.out.printf("%.2f%%%n", p4 / numbers * 100);
        System.out.printf("%.2f%%", p5 / numbers * 100);
    }
}
