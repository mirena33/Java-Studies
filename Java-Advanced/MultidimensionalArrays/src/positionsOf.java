import java.util.Arrays;
import java.util.Scanner;

public class positionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dim[0]][dim[1]];


        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++) {
                int value = Integer.parseInt(line[col]);
                matrix[row][col] = value;


            }
        }

        int searchNumber = Integer.parseInt(scanner.nextLine());

        boolean hasNoMatch = true;

        for (int row = 0; row < matrix.length; row++) {
            int[] eachArray = matrix[row];

            for (int col = 0; col < eachArray.length; col++) {
                int value = eachArray[col];

                if (value == searchNumber){
                    System.out.println(row + " " + col);
                    hasNoMatch = false;
                }

            }
        }

        if (hasNoMatch){
            System.out.println("not found");
        }

    }
}
