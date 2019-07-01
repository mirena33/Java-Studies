import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = hours * 60 + minutes + 30;

        int rHours = totalMinutes / 60;
        int rMinutes = totalMinutes % 60;

        if (rHours >= 24) {
            rHours = 0;
        }
        System.out.printf("%d:%02d", rHours, rMinutes);
    }
}
