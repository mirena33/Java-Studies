import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        String input = "";

        while (!"END".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equalsIgnoreCase("swap") && tokens.length == 5) {

                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);

                if (isInBounds(matrix, firstRow, firstCol) && isInBounds(matrix, secondRow, secondCol)) {

                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;

                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {

        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
