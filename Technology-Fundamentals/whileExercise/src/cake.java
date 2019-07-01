import java.util.Scanner;

public class cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakeSize = width * length;

        String input = scanner.nextLine();

        while (!"STOP".equals(input)) {
            int piece = Integer.parseInt(input);
            cakeSize -= piece;

            if (cakeSize < 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakeSize));
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("%d pieces are left.", cakeSize);


    }
}
