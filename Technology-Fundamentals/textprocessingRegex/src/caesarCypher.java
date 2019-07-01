import java.util.Scanner;

public class caesarCypher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        for (int i = 0; i < data.length(); i++) {

            int resultChar = data.charAt(i) + 3;

            char res = (char) resultChar;
            System.out.print(res);

        }
    }
}
