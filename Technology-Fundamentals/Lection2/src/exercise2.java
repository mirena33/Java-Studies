import java.util.Scanner;

public class exercise2 {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        double r = Double.parseDouble(inputReader.nextLine());
        double area = Math.PI * Math.pow(r, 2);
        double perimeter = 2 * Math.PI * r;


        System.out.printf("Area = %f%n", area );
        System.out.printf("Perimeter = %f", perimeter);
    }
}
