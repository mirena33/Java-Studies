import java.util.Scanner;

public class operationBetweenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double result = 0.0;
        String output = "";

        switch (operator) {
            case '+':
                result = num1 + num2;
                output = String.format("%d %c %d = %.0f", num1, operator, num2, result);


                break;
            case '-':
                result = num1 - num2;
                output = String.format("%d %c %d = %.0f", num1, operator, num2, result);

                break;
            case '*':
                result = num1 * num2;
                output = String.format("%d %c %d = %.0f", num1, operator, num2, result);
                break;

            case '/':
                if (num2 == 0) {
                    output = "Cannot divide " + num1 + " by zero";
                } else {
                    result = num1 * 1.0 / num2;
                    output = String.format("%d %c %d = %.2f", num1, operator, num2, result);
                }
                break;

            case '%':
                if (num2 == 0) {
                    output = "Cannot divide " + num1 + " by zero";
                } else {

                    result = num1 % num2;
                    output = String.format("%d %c %d = %.0f", num1, operator, num2, result);
                }
                break;
        }

        if (operator == '+' || operator == '-' || operator == '*') {
            if (result % 2 == 0) {
                output += " - even";
            } else {
                output += " - odd";
            }
        }
        System.out.println(output);
    }
}

