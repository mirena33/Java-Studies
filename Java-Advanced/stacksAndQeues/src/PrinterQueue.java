import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"print".equalsIgnoreCase(input = scanner.nextLine())) {

            if (!"cancel".equalsIgnoreCase(input)) {
                queue.offer(input);

            } else {
                if (!queue.isEmpty()) {
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }


        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
