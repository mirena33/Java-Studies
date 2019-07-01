import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String exp = scanner.nextLine();

        String[] tokens = exp.split("\\s+");

        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {

            Integer firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());

            if ("+".equalsIgnoreCase(op)) {

                stack.push(firstNum + secondNum + "");
            } else {
                stack.push(firstNum - secondNum + "");
            }
        }
        System.out.println(stack.peek());
    }
}
