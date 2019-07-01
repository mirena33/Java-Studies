import java.util.Scanner;

public class scannerChar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String result = "";

        for (int i = 0; i < 3; i++) {
            char input = scanner.next().charAt(0);
            result = result + input;
        }

        System.out.println(result);
    }
}
