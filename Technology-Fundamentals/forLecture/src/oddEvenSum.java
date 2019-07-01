import java.util.Scanner;

public class oddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        if (evenSum == oddSum) {
            System.out.printf("Yes Sum = %d", evenSum);
        } else {
            System.out.printf("No Diff = %d", Math.abs(evenSum - oddSum));
        }


    }
}
