import java.util.Arrays;
import java.util.Scanner;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[row][];

        for (int r = 0; r < matrix.length; r++) {

            String[] data = scanner.nextLine().split(",\\s+");
            matrix[r] = new String[data.length];

            for (int c = 0; c < data.length; c++) {

                matrix[r][c] = data[c];
            }
        }

        String[] data = scanner.nextLine().split("\\s+");
        String command = data[0];
        String header = data[1];

        switch (command){
            case "hide":

                break;

            case "sort":

                break;

            case "filter":

                break;
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == matrix[row].length - 1){
                    System.out.print(matrix[row][col]);
                }else {
                    System.out.print(matrix[row][col] + " | ");
                }
            }
            System.out.println();
        }
    }
}
