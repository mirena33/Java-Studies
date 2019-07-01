import java.util.Scanner;

public class calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                adding(firstNumber, secondNumber);
                break;

            case "multiply":
                multiplying(firstNumber, secondNumber);
                break;

            case "subtract":
                subtracting(firstNumber, secondNumber);
                break;

            case "divide":
                dividing(firstNumber, secondNumber);
                break;

            default:
                break;
        }
    }

    private static void dividing(int firstNumber, int secondNumber) {

        int result = firstNumber / secondNumber;
        System.out.println(result);
    }

    private static void subtracting(int firstNumber, int secondNumber) {

        int result = firstNumber - secondNumber;
        System.out.println(result);
    }

    private static void multiplying(int firstNumber, int secondNumber) {

        int result = firstNumber * secondNumber;
        System.out.println(result);
    }

    private static void adding(int firstNumber, int secondNumber) {

        int result = firstNumber + secondNumber;
        System.out.println(result);
    }
}
