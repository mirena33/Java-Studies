import java.util.Scanner;

public class extractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

            if (text.charAt(text.length() - 1) == '\\'){
                text = text.substring(0, text.length() - 1);
            }

        text = text.substring(text.lastIndexOf('\\') + 1);

        String name = text.substring(0, text.lastIndexOf('.'));
        String extension = text.substring(text.lastIndexOf('.') + 1);

        System.out.printf("File name: %s\n", name);
        System.out.printf("File extension: %s\n", extension);
    }
}
