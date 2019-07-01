import java.util.Scanner;

public class substitute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        for (int i = k; i <= 8 ; i++) {
            for (int j = 9; j >= l ; j--) {
                for (int c = m; c <= 8 ; c++) {
                    for (int d = 9; d >= n ; d--) {
                        if (i % 2 == 0 && j % 2 == 1 && c % 2 == 0 && d % 2 == 1) {
                            if (counter == 6) {
                                continue;
                            }

                            if (i == c && j == d) {
                                System.out.println("Cannot change the same player.");
                            } else {
                                System.out.printf("%d%d - %d%d\n", i, j, c, d);
                                counter++;
                            }

                        }
                    }
                }
            }
        }
    }
}
