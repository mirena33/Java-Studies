import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //BROWSER HISTORY

        ArrayDeque<String> stack = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!"Home".equals(input = scanner.nextLine())) {

            if (!"back".equalsIgnoreCase(input)) {

                stack.push(input);
                System.out.println(input);

            } else {

                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
        }

    }
}
