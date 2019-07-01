import java.util.Scanner;

public class spiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int leftOvers = 0;
        int days = 0;
        int sum = 0;


        while (startingYield >= 100) {


            days++;

            leftOvers = startingYield;
            leftOvers -= 26;
            sum += leftOvers;

            startingYield -= 10;
            if (startingYield < 100) {
                sum -= 26;
            }
        }


        System.out.printf("%d\n%d", days, sum);

    }
}
