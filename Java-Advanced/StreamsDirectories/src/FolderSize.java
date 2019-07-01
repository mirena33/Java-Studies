import java.io.File;

public class FolderSize {
    public static void main(String[] args) {

        String filePath =
                "C:\\Users\\MIRENA\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File[] file = new File(filePath).listFiles();

        int sum = 0;

        for (File f : file) {
            sum += f.length();
        }

        System.out.println("Folder size: " + sum);
    }
}
