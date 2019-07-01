import java.text.DecimalFormat;
import java.util.Scanner;

public class mathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double b = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(df.format(operation(a, operator, b)));


    }

    public static double operation(double a, String operator, double b) {

        double result = 0;

        switch (operator) {
            case "/":
                result = a / b;
                break;

            case "*":
                result = a * b;
                break;

            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            default:
                break;
        }

        return result;
    }
}
