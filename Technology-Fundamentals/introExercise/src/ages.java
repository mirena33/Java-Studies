import java.util.Scanner;

public class ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        if (input >= 0 && input <= 2) {
            System.out.println("baby");
        } else if (input <= 13) {
            System.out.println("child");
        } else if (input <= 19) {
            System.out.println("teenager");
        } else if (input <= 65) {
            System.out.println("adult");
        } else if (input >= 66) {
            System.out.println("elder");
        }
    }
}