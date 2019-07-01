import java.util.Scanner;

public class SpaceC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][];

        int rowStephen = 0;
        int colStephen = 0;

        for (int row = 0; row < size; row++) {

            char[] line = scanner.nextLine().toCharArray();
            matrix[row] = new char[line.length];

            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'S') {
                    rowStephen = row;
                    colStephen = col;
                }
            }
        }

        int energy = 0;
        boolean canMove = true;

        while (energy < 50 && canMove) {
            String comand = scanner.nextLine();

            matrix[rowStephen][colStephen] = '-';

            if (comand.equals("right")) {
                if (!canGo(matrix, rowStephen, colStephen + 1)) {
                    canMove = false;
                    matrix[rowStephen][colStephen] = '-';
                    break;
                }
                colStephen++;

            } else if (comand.equals("left")) {
                if (!canGo(matrix, rowStephen, colStephen - 1)) {
                    canMove = false;
                    matrix[rowStephen][colStephen] = '-';
                    break;
                }
                colStephen--;

            } else if (comand.equals("down")) {

                if (!canGo(matrix, rowStephen + 1, colStephen)) {
                    canMove = false;
                    matrix[rowStephen][colStephen] = '-';
                    break;
                }
                rowStephen++;

            } else if (comand.equals("up")) {
                if (!canGo(matrix, rowStephen - 1, colStephen)) {
                    canMove = false;
                    matrix[rowStephen][colStephen] = '-';
                    break;
                }
                rowStephen--;
            }

            if (isDigit(matrix, rowStephen, colStephen)) {
                char number = matrix[rowStephen][colStephen];
                energy += Integer.parseInt(String.valueOf(number));
            }

            if (matrix[rowStephen][colStephen] == 'O') {
                matrix[rowStephen][colStephen] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] == 'O') {
                            rowStephen = i;
                            colStephen = j;
                        }
                    }
                }
            }
            matrix[rowStephen][colStephen] = 'S';

        }
        if (!canMove) {
            System.out.println("Bad news, the spaceship went to the void.");
            System.out.println("Star power collected: " + energy);
        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
            System.out.println("Star power collected: " + energy);
        }

        printData(matrix);

    }

    private static void printData(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isDigit(char[][] matrix, int rowStephen, int colStephen) {
        return Character.isDigit(matrix[rowStephen][colStephen]);
    }

    private static boolean canGo(char[][] matrix, int rowStephen, int colStephen) {
        return rowStephen >= 0 && rowStephen < matrix.length && colStephen >= 0 && colStephen < matrix[rowStephen].length;
    }
}
