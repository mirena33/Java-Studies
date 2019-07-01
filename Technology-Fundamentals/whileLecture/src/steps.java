import java.util.Scanner;

public class steps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int target = 10000;

        int sum = 0;

        while (sum < target) {
            if (input.equals("Going home")) {
                input = scanner.nextLine();
                sum += Integer.parseInt(input);
                break;
            }

            int steps = Integer.parseInt(input);
            sum += steps;
            if (sum >= target) {
                input = scanner.nextLine();
            }
        }
        if (sum >= target) {
            System.out.println("Goal reached! Good job!");
        } else {
            System.out.printf("%d more steps to reach goal.",Math.abs(target - sum));
        }
    }
}
