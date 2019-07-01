import java.util.Scanner;

public class characterInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        System.out.print(range(start, end));

    }


    static String range(char start, char end) {
        String result = "";

        if (start > end) {
            for (int i = end + 1; i < start; i++) {
                result += (char) i + " ";
            }
        } else {
            for (int i = start + 1; i < end; i++) {
                result += (char) i + " ";
            }
        }

        return result;
    }
}
