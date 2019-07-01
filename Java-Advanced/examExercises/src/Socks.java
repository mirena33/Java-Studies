import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        List<Integer> pairs = new ArrayList<>();

        int[] numbersStack = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbersStack.length; i++) {
            stack.push(numbersStack[i]);
        }

        for (int i = 0; i < numbersQueue.length; i++) {
            queue.offer(numbersQueue[i]);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.peek().equals(queue.peek())) {
                queue.poll();

                int increment = stack.pop() + 1;
                stack.push(increment);

            } else if (queue.peek() > stack.peek()) {
                stack.poll();


            } else if (queue.peek() < stack.peek()) {

                int pair = queue.poll() + stack.pop();

                pairs.add(pair);

            }
        }

        System.out.println(Collections.max(pairs));
        pairs.forEach(e -> System.out.print(e + " "));
    }
}
