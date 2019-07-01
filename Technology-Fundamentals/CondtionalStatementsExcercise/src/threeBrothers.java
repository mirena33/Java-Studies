import java.net.DatagramPacket;
import java.util.Scanner;

public class threeBrothers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstBroTime = Double.parseDouble(scanner.nextLine());
        double secondBroTime = Double.parseDouble(scanner.nextLine());
        double thirdBroTime = Double.parseDouble(scanner.nextLine());
        double fatherTime = Double.parseDouble(scanner.nextLine());

        double allTime = (1 / (1 / firstBroTime + 1 / secondBroTime + 1 / thirdBroTime)) *1.15;

        //double allTime = allBroTime + (allBroTime * 0.15);

        System.out.printf("Cleaning time: %.2f%n", allTime);
        if (fatherTime < allTime) {
            System.out.printf("No, there isn't a surprise " +
                    "- shortage of time -> " + "%.0f hours.", Math.ceil(allTime - fatherTime));
        } else {
            System.out.printf("Yes, there is a surprise - time left -> " + "%.0f hours.", Math.floor(fatherTime - allTime));
        }
    }
}
