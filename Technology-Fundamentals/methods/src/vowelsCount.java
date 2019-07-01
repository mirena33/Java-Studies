import java.util.Scanner;

public class vowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (isVowel(text.charAt(i))) {
                count++;
            }

        }

        System.out.println(count);
    }

    static boolean isVowel(char symbol) {
        switch (symbol) {
            case 'a':
            case 'e':
            case 'o':
            case 'i':
            case 'u':
            case 'y':
                return true;
        }
        return false;
    }
}
