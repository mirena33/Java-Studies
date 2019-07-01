import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String filePath =
                "C:\\Users\\MIRENA\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileReader fileReader = new FileReader(filePath);

        BufferedReader reader = new BufferedReader(fileReader); // na buffedReader mu trqbva potok ot danni, t.e. fileReader

        String line = reader.readLine();

        BigInteger totalSum = BigInteger.ZERO;

        while (line != null) {

            for (char symbol : line.toCharArray()) {

                totalSum = totalSum.add(BigInteger.valueOf(symbol));
            }

            line = reader.readLine();
        }

        PrintWriter printer = new PrintWriter("BigIntOut.txt");

        printer.println(totalSum.toString());

        printer.close();
    }
}
