import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class houseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            if (data[2].equals("not")) {
                if (!names.contains(data[0])) {
                    System.out.printf("%s is not in the list!\n", data[0]);
                }
                names.remove(data[0]);

            } else {
                if (names.contains(data[0])) {
                    System.out.printf("%s is already in the list!\n", data[0]);
                } else {
                    names.add(data[0]);
                }
            }
        }

        System.out.println(String.join("\n", names));
    }
}
