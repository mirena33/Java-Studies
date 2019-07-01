import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dim[0]][dim[1]];

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(", ");

            for (int col = 0; col < line.length; col++) {
                int nums = Integer.parseInt(line[col]);
                sum += nums;
            }
        }

        System.out.println(dim[0]);
        System.out.println(dim[1]);
        System.out.println(sum);
    }
}
