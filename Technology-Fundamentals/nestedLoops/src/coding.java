import java.util.Scanner;

public class coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int tempNum = 0;
        int charNum = 0;

        for (int i = 0; i <= number + 1; i++) {

            tempNum = number % 10;
            charNum = tempNum + 33;

            if (tempNum == 0) {
                System.out.println("ZERO");
                number /= 10;
                continue;
            }

            for (int j = 0; j < tempNum; j++) {
                System.out.print((char) charNum);

            }
            number /=10;
            System.out.println();
        }

    }
}
