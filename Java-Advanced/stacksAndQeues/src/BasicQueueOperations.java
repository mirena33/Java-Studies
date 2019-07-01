import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToAdd = parameters[0];
        int elementsToRemove = parameters[1];
        int elementToCheck = parameters[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsToAdd)
                .forEach(queue::offer);


        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }

        if (queue.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            if (queue.size() == 0) {
                System.out.println(0);
            } else {

                System.out.println(Collections.min(queue));
            }
        }
    }
}
