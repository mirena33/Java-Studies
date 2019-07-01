import java.util.Scanner;

public class plusFifteenMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int countMin = minutes + 15;


        if (countMin <= 59) {
            System.out.println(hour + ":" + countMin);
        } else if (countMin <= 69) {
            int outputHour = hour + 1;
            if (outputHour > 23) {
                outputHour = 0;
            }
            int outputMin = Math.abs(60 - countMin);
            System.out.println(outputHour + ":0" + outputMin);
        } else if (countMin > 69) {
            int outputHour = hour + 1;
            if (outputHour > 23) {
                outputHour = 0;
            }
            int outputMin = Math.abs(60 - countMin);
            System.out.println(outputHour + ":" + outputMin);
        }
    }
}
