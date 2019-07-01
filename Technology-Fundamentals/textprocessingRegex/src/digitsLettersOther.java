import java.util.Scanner;

public class digitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String resDigit = "";
        String resLetter = "";
        String resOther = "";

        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))){
               resDigit += input.charAt(i);

            } else if (Character.isLetter(input.charAt(i))){
                resLetter += input.charAt(i);

            } else {
              resOther += input.charAt(i);
            }
        }

        System.out.println(resDigit);
        System.out.println(resLetter);
        System.out.println(resOther);
    }
}
