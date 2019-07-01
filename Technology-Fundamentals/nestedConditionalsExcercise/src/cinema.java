import java.util.Scanner;

public class cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projection = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        switch (projection) {
            case "Premiere":
                price = 12;
                break;
            case  "Normal":
                price = 7.5;
                break;

            case "Discount":
                price = 5;
                break;
        }
        System.out.printf("%.2f leva", price * r * c);
    }
}
