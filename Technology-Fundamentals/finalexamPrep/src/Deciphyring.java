import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphyring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String[] substring = scanner.nextLine().split("\\s+");
        String result = "";

        Pattern pattern = Pattern.compile("[d-z]+[{}|#]*");

        Matcher matcher = pattern.matcher(message);


        if (matcher.matches()) {


            for (int i = 0; i < message.length(); i++) {
                result = result + Character.toString(message.charAt(i) - 3);
            }

            for (int i = 0; i < result.length(); i++) {
                if (result.contains(substring[0])) {
                    result = result.replace(substring[0], substring[1]);
                }
            }

            System.out.println(result);

        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
