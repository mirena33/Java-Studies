import java.util.Scanner;

public class partyInvitation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int validCount = 0;
        int invalidCount = 0;
        int namesCount = 0;


        while (!"Statistics".equals(input)) {
            boolean valid = true;
            namesCount++;
            input = input.toLowerCase();

            for (int i = 0; i < input.length(); i++) {
                input = input.toLowerCase();
                char symbol = input.charAt(i);

                if (symbol < 97 || symbol > 122) {

                    invalidCount++;
                    System.out.println("Invalid name!");
                    valid = false;

                }
            }

            if (valid) {

                validCount++;
                input = input.substring(0,1).toUpperCase() + input.substring(1);
                System.out.printf("%s\n", input);

            } else {

                invalidCount++;
                System.out.println("Invalid name!");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Valid names are %.2f%% from %d names.\n", (validCount * 1.00 / namesCount)*100, namesCount);
        System.out.printf("Invalid names are %.2f%% from %d names.\n", (invalidCount * 1.00 / namesCount)*100, namesCount);
    }
}
