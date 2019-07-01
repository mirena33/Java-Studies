import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

        String result = "";

        for (int i = 0; i <inputArr.length ; i++) {
            String e1 = inputArr[i];
            int length = e1.length();
            for (int j = 0; j < length; j++) {
                result += e1;
            }
        }

        System.out.println(result);
    }
}
