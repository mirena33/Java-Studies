import java.util.Arrays;
import java.util.Scanner;

public class condenseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] condensed = new int[nums.length - 1];

        int sum = 0;


        for (int i = 0; i < nums.length - 1; i++) {

            condensed[i] = nums[i] + nums[i + 1];


        }

        if (sum == 0) {
            System.out.println(nums[0] + " is already condensed to number");
        } else {
            System.out.println(sum);
        }
    }
}
