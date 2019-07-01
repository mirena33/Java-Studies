import java.util.Scanner;

public class replaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append(arr[i]);
            }
            if (i == arr.length - 1) {
                break;
            } else {


                if (!arr[i].equals(arr[i + 1])) {

                    sb.append(arr[i + 1]);
                }
            }

        }

        System.out.println(sb.toString());
    }
}
