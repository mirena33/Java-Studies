import java.util.Scanner;

public class rowOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        while (!a.equals("END")) {
            int num = Integer.parseInt(a);
            if (num > maxValue) {
                maxValue = num;
            }
            if (num < minValue) {
                minValue = num;
            }
            a = scanner.nextLine();
        }
        System.out.printf("Max number: %d%nMin number: %d", maxValue, minValue);
    }
}
