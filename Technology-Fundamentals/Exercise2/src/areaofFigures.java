import java.util.Scanner;

public class areaofFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (input.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", side*side);
        }
        else if (input.equals("rectangle")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", side1*side2);
        }
        else if (input.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", Math.PI * r * r);
        }
        else if (input.equals("triangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", (a*b)/2);
        }




    }
}
