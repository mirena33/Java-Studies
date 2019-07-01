import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^[A-Z][a-z\\'\\s]+:[A-Z\\s]+$");

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String[] data = input.split("\\:");
                int key = data[0].length();

                String encryptedString = "";

                for (int i = 0; i < input.length(); i++) {

                    char currentChar = input.charAt(i);

                    if (currentChar != '\'' && currentChar != ' ' && currentChar != ':') {
                        int currentCharASCII = (int) currentChar;

                        if (currentCharASCII >= 65 && currentCharASCII <= 90) {
                            currentCharASCII += key;

                            if (currentCharASCII > 90) {
                                currentCharASCII = (currentCharASCII % 90) + 64;
                            }
                        } else {
                            currentCharASCII += key;

                            if (currentCharASCII > 122) {
                                currentCharASCII = (currentCharASCII % 122) + 96;
                            }
                        }

                        currentChar = (char) currentCharASCII;
                    }
                    encryptedString += currentChar;
                }


                System.out.println("Successful encryption: " + encryptedString.replace(':', '@'));

            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
