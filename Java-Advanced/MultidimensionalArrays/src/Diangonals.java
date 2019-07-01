import java.util.Scanner;

public class Diangonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < line.length; col++) {

                int value = Integer.parseInt(line[col]);
                matrix[row][col] = value;

            }
        }

        int countR = 0;
        int countC = 0;

        for (int row = 0; row < matrix.length; row++) {
            int[] eachArray = matrix[row];
            for (int col = 0; col < eachArray.length; col++) {

                if (countR < size && countC < size) {
                    System.out.print(matrix[countR++][countC++] + " ");
                }
            }
        }

        System.out.println();

        int counterR = matrix.length - 1;
        int counterC = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int[] eachArray = matrix[row];
            for (int col = 0; col <= eachArray.length; col++) {

                if (counterR >= 0 && counterC < size){
                    System.out.print(matrix[counterR--][counterC++] + " ");
                }
            }
        }
    }
}
