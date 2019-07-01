import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //SUM LINES

        String filePath =
                "C:\\Users\\MIRENA\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        String fileOutput = filePath.substring(0,
                filePath.lastIndexOf("\\") + 1) + "ASCIIsum.txt";

        FileWriter fileWriter = new FileWriter(fileOutput);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line = reader.readLine();

            while (line != null) {

                int ASCIIsum = 0;

                for (char symbol : line.toCharArray()) {

                    ASCIIsum += symbol;
                }


                fileWriter.write(ASCIIsum + ""); // za da stane na String
                fileWriter.write(System.lineSeparator());


                line = reader.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        fileWriter.close();

    }
}
