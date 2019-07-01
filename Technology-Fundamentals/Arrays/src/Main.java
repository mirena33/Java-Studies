import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfday = Integer.parseInt(scanner.nextLine());

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };


        if (numberOfday <= 0 || numberOfday > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[numberOfday - 1]);
        }
    }
}
