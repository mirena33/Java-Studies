import java.util.Scanner;

public class passwordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (isInRage(password) && isLetterOrDigit(password) && haveAtLeast2digits(password)) {
            System.out.println("Password is valid");

        } else {

            if (!isInRage(password)){
                System.out.println("Password must be between 6 and 10 characters");
            }
            if (!isLetterOrDigit(password)){
                System.out.println("Password must consist only of letters and digits");
            }
            if (!haveAtLeast2digits(password)){
                System.out.println("Password must have at least 2 digits");
            }


        }

    }

    static boolean isInRage(String password) {

        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }

        return false;
    }

    static boolean isLetterOrDigit(String password) {

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)){

              return false;
            }

        }

        return true;
    }

    private static boolean haveAtLeast2digits(String password) {

        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}

