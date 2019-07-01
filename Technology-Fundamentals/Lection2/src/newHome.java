import java.util.Scanner;

public class newHome {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
     double rad = Double.parseDouble(inputReader.nextLine());
     double deg = rad * 180 / Math.PI;
        System.out.printf("%.0f", deg);

    }
}
