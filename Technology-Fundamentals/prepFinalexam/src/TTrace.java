import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^([#$%*&])([A-Za-z]+)\\1=([\\d]+)!!(.*$)");

        String geogash = "";


        while (true) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int key = Integer.parseInt(matcher.group(3));
                int length = input.length();
                if (key == matcher.group(4).length()) {
                    for (int i = 0; i < matcher.group(4).length(); i++) {
                        geogash = geogash + (char) (matcher.group(4).charAt(i) + key);
                    }

                    System.out.println("Coordinates found! " + matcher.group(2) + " -> " + geogash);
                    break;

                } else {
                    System.out.println("Nothing found!");
                }


            } else {
                System.out.println("Nothing found!");
            }

        }
    }
}
