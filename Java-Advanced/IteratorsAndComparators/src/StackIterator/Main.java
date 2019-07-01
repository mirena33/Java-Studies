package StackIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        String[] initialValues = scanner.nextLine().split("\\s+");

        stack.push(Integer.parseInt(initialValues[0].split(",\\s+")[1]));

        for (int i = 0; i < initialValues.length; i++) {
            stack.push(Integer.parseInt(initialValues[i]));
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (input.equals("Pop")) {
                try {
                    stack.pop();
                }catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }

            } else {
                stack.push(Integer.parseInt(input.split("\\s+")[1].trim()));
            }

            input = scanner.nextLine();
        }

        for (int number : stack) {
            System.out.println(number);
        }
        for (int number : stack) {
            System.out.println(number);
        }
    }
}
