import java.util.Scanner;

public class worldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double WR = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeSeconds = Double.parseDouble(scanner.nextLine());

        double swimmingDistance = distance * timeSeconds;
        double resistance = Math.floor(distance /15) * 12.5;
        double allTime = swimmingDistance + resistance;


        if (allTime < WR) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", allTime);

        }
        else {
            double fail = allTime - WR;
            System.out.printf("No, he failed! He was %.2f seconds slower.", fail);
        }



    }
}
