import java.util.Scanner;

public class greaterOfTwoValues {

    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static char getMax(char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        if ("int".equals(type)) {
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());

            System.out.println(getMax(a, b));

        } else if ("char".equals(type)) {
            char a = scanner.nextLine().charAt(0);
            char b = scanner.nextLine().charAt(0);

            System.out.println(getMax(a, b));

        } else if ("string".equals(type)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            System.out.println(getMax(a, b));
        }

    }
}
