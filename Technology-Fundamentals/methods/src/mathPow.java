import java.text.DecimalFormat;
import java.util.Scanner;

public class mathPow {
    public static double mathPower(double number, int power) {
        double result = 1.00;

        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");

        if (number == 0) {
            System.out.println(0);
        } else {

            System.out.println(df.format(mathPower(number, power)));
        }
    }
}
