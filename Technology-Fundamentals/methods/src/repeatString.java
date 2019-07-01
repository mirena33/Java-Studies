import java.util.Scanner;

public class repeatString {

    private static String repString(String str, int count) {
        String result = "";

        for (int i = 0; i < count; i++) {
            result += str;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int count = Integer.parseInt(scanner.nextLine());

        System.out.println(repString(input, count));
    }
}
