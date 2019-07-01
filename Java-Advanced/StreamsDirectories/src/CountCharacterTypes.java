import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String filePath =
                "C:\\Users\\MIRENA\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        String text = Files.readString(Path.of(filePath)).replaceAll("\r\n", " "); // \r is like lineSeparator

        int[] countData = new int[3];

        String vowels = "aeiou";
        String pon = "!,.?";

        for (char symbol : text.toCharArray()) {

            if (vowels.contains(symbol + "")) {

            } else if (pon.contains(symbol + "")) {
                countData[2]++;
            }
        }

        PrintWriter printer = new PrintWriter("TypeOutput.txt");

        printer.printf("Vowels: %d\n" +
                        "Consonants: %d\n" +
                        "Punctuation: %d",
                countData[0],
                countData[1],
                countData[2]);

    }
}
