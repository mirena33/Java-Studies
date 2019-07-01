import java.util.Arrays;
import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = -1;
        int sum = 0;

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                index = i;
                break;
            }
            sum += firstArray[i];
        }

        if (index == -1) {
            System.out.println("Arrays are identical. Sum: " + sum);
        } else {
            System.out.println("Arrays are not identical. Found difference at " + index + " index.");
        }
    }
}
