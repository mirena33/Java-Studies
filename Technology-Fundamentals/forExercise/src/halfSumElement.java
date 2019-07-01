import java.util.Scanner;

public class halfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num >= maxValue) {
                maxValue = num;

            }

        }
        if (maxValue == (sum - maxValue)) {

            System.out.printf("Yes Sum = %d", maxValue);
        } else {
            System.out.printf("No, diff = %d", Math.abs(maxValue - (sum - maxValue)));
        }


    }
}
