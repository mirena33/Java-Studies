import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {

        String filePath =
                "C:\\Users\\MIRENA\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\image.jpg";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        byte[] image = fileInputStream.readAllBytes();

        FileOutputStream outputStream = new FileOutputStream("dot.jpeg");

        outputStream.close();

        //NOT DONE
    }
}
