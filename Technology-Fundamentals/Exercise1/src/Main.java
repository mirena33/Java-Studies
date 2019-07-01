import java.util.Scanner;

//2D rectangle area

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double c1 = Math.max(x1, x2) - Math.min(x1, x2);
        double c2 = Math.max(y1, y2) - Math.min(y1, y2); // namirame po golemiq x/y i ot nego izvajdame po malkiq

        double area = c1 * c2;
        double perimeter = (c1 + c2) * 2;

        System.out.println(area);
        System.out.println(perimeter);


    }
}
