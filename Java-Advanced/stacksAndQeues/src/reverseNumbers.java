import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class reverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stack::push); //(e - > stack.push(e))


        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
