import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = "";

        while (!"home".equalsIgnoreCase(input = scanner.nextLine())) {

            if ("back".equalsIgnoreCase(input)) {

                if (stack.size() > 1){
                    stack.pop();

                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }


            } else if ("forward".equalsIgnoreCase(input)){

                if (queue.size() > 1){

                    System.out.println(queue.poll());
                } else {
                    System.out.println("no next URLs");
                }

            }

                else {
                stack.push(input);
                queue.offer(input);
                System.out.println(input);
            }
        }
    }
}
