import java.util.Scanner;

public class textFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();


        for (String word : bannedWords) {

            String replacement = "";

            if (text.contains(word)){
                 replacement = doMagic(word);
            }

            text = text.replace(word, replacement);

        }

        System.out.println(text);
    }


    private static String doMagic(String word) {
        String replacement = "";
        for (int i = 0; i < word.length(); i++) {
            replacement += "*";
        }

        return replacement;
    }
}
