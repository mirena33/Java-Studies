import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class hotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] names = scanner.nextLine().split("\\s+");

        Collections.addAll(queue, names);

        int n = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {

                queue.offer(queue.poll());
            }

        }
        System.out.println("Removed " + queue.poll());


        System.out.println("Last is " + queue.poll());
    }
}
