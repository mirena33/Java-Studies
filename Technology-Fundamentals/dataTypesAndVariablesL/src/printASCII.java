import java.util.Scanner;

public class printASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        for (int i = startNum; i <= endNum; i++) {

            char symbol = (char) i;

            System.out.printf("%c ", symbol);
        }
    }
}
