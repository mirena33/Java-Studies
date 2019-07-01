import java.util.Scanner;

public class validUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");

        for (String word: words
             ) {
            if (validateWords(word)){
                System.out.println(word);
            }
        }

    }

    private static boolean validateWords(String word){
        if (word.length() < 3 | word.length() > 16){
            return false;
        }


        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))
            && word.charAt(i) != '-'
            &&word.charAt(i) != '_'){
                return false;
            }
        }

        return true;
    }
}
