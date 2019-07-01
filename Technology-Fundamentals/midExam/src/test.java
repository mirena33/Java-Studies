import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());

        double totalEffort = 0.0;
        int totalFire = 0;
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {

            double currentEffort = 0.0;

            String[] data = input[i].split(" = ");

            if (data.length > 2){
                break;
            }

            System.out.println(data[0]);
            System.out.println(data[1]);
        }

    }
}
