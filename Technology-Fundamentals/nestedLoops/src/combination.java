import java.util.Scanner;

public class combination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=n ; j++) {
                for (int k = 0; k <=n ; k++) {
                    for (int l = 0; l <=n ; l++) {
                        for (int m = 0; m <=n ; m++) {
                            int sum = i + j + k + l + m;

                            if (sum == n) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(counter);
    }
}
