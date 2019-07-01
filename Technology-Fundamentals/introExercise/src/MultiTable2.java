import java.util.Scanner;

public class MultiTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        if (times > 10) {
            System.out.println(String.format("%d X %d = %d", number, times, number*times));
        }

        while (times <= 10) {

            System.out.println(String.format("%d X %d = %d", number, times, number * times));
            times++;
        }
    }
}
