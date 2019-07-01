import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String reversedUsername = "";
        int counter = 1;

        for (int i = username.length()-1; i >= 0; i--) {

            //konkatenira otdelni charove v string:

            reversedUsername = reversedUsername + username.charAt(i);
        }

        String inputData = scanner.nextLine();


        while (!inputData.equals(reversedUsername)) {
            counter++;
            if (counter > 4) {
                System.out.println(String.format("User %s blocked!", username));
                return;
            }

            System.out.println("Incorrect password. Try again.");
            inputData = scanner.nextLine();


        }

        System.out.printf("User %s logged in.", username);
    }
}
