import java.util.Scanner;

public class izpitnaZad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (char i = 'B'; i <= 'L'; i+=2) {
            for (char j = 'f'; j > 'a' ; j++) {
                for (char k = 'A'; k <= 'C' ; k++) {
                    for (int l = 1; l <= 10 ; l++) {
                        for (int m = 10; m >= 1 ; m--) {
                            count++;
                            if (n == count) {
                                int result = i + j + k + l + m;
                                System.out.printf("Ticket combination: %c%c%c%d%d\n", i, j, k , l, m);
                                System.out.printf("Prize: %d lv.", result);
                            }
                        }
                    }
                }
            }
        }

    }
}
