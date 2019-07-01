import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        String expr = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {
            char openBracket = expr.charAt(i);

            if ('(' == openBracket){
                stack.push(i);

            } else if (')' == openBracket){
                System.out.println(expr.substring(stack.pop(), i + 1));
            }
        }
    }
}
