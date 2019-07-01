import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int half = (N * 50) / 100;

        while (N >= M) {
            count++;
            N -= M;

            if (half == N) {
                if (Y > 0) {
                    N /= Y;
                }

            }

        }

        System.out.println(N);
        System.out.println(count);

    }
}
