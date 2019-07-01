import java.util.Scanner;

public class minNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < minNumber) {
                minNumber = num;
            }

        }
        System.out.println(minNumber);
    }
}
