import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();

        String text = scanner.nextLine();

        int indexOfKey = text.indexOf(keyWord);

        while (indexOfKey != -1){
           text = text.substring(0, indexOfKey) + text.substring(indexOfKey + keyWord.length());

         indexOfKey = text.indexOf(keyWord);
        }
        System.out.println(text);
    }
}
