package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String str = scanner.next();

            Box<String> box = new Box<>(str);

            System.out.println(box.toString());

        }
    }
}
