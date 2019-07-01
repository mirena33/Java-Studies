import java.util.Scanner;

public class factorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());

        double factorialDivision = factorial(firstNumber) / factorial(secondNumber);

        System.out.printf("%.2f", factorialDivision);
    }

    static double factorial(double number){

        double result = 1;

        for (int i = 1; i <= number ; i++) {
            result *= i;
        }
        return result;
    }
}
