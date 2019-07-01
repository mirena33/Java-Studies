import java.util.Scanner;

public class TronRacers {

    private static int firstPlayerRow = 0;
    private static int firstPlayerCol = 0;
    private static int secondPlayerRow = 0;
    private static int secondPlayerCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] field = initializeField(scanner, matrixSize);

        boolean isFirstPlayerAlive = true;
        boolean isSecondPlayerAlive = true;

        while (isFirstPlayerAlive && isSecondPlayerAlive) {

            String[] input = scanner.nextLine().split("\\s+");
            String firstCommand = input[0];
            String secondCommand = input[1];

            isFirstPlayerAlive = moveFirstPlayer(firstCommand, field);

            if (!isFirstPlayerAlive){
                break;
            }

            isSecondPlayerAlive = moveSecondPlayer(secondCommand, field);

        }

        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static boolean moveFirstPlayer(String firstCommand, char[][] field) {
        int newPositionRow = firstPlayerRow;
        int newPositionCol = firstPlayerCol;
        boolean isAlive = true;


        switch (firstCommand) {
            case "up":
                if (newPositionRow == 0) {
                    newPositionRow = field.length - 1;
                } else {
                    newPositionRow--;
                }
                break;

            case "down":
                if (newPositionRow == field.length - 1) {
                    newPositionRow = 0;
                } else {
                    newPositionRow++;
                }
                break;

            case "left":
                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol--;
                }
                break;

            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol++;
                }
                break;
        }

        char newElement = field[newPositionRow][newPositionCol];

        if (newElement == 's') {
            field[newPositionRow][newPositionCol] = 'x';
            isAlive = false;

        } else {
            field[newPositionRow][newPositionCol] = 'f';
        }

        firstPlayerRow = newPositionRow;
        firstPlayerCol = newPositionCol;

        return isAlive;
    }

    private static boolean moveSecondPlayer(String secondCommand, char[][] field) {
        int newPositionRow = secondPlayerRow;
        int newPositionCol = secondPlayerCol;

        boolean isAlive = true;

        switch (secondCommand) {
            case "up":
                newPositionRow = newPositionRow == 0 ? field.length - 1 : newPositionRow - 1;
                break;

            case "down":
                newPositionRow = newPositionRow == field.length - 1 ? 0 : newPositionRow + 1;
                break;

            case "left":
                if (newPositionCol == 0) {
                    newPositionCol = field.length - 1;
                } else {
                    newPositionCol = newPositionCol - 1;
                }
                break;

            case "right":
                if (newPositionCol == field.length - 1) {
                    newPositionCol = 0;
                } else {
                    newPositionCol = newPositionCol + 1;
                }
                break;
        }

        char newElement = field[newPositionRow][newPositionCol];
        if (newElement == 'f') {
            field[newPositionRow][newPositionCol] = 'x';
            isAlive = false;

        } else {
            field[newPositionRow][newPositionCol] = 's';
        }

        secondPlayerRow = newPositionRow;
        secondPlayerCol = newPositionCol;

        return isAlive;
    }

    private static char[][] initializeField(Scanner scanner, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputLine = scanner.nextLine().toCharArray();

            for (int col = 0; col < matrixSize; col++) {
                char element = inputLine[col];

                matrix[row][col] = element;

                if (element == 'f') {
                    firstPlayerRow = row;
                    firstPlayerCol = col;

                } else if (element == 's') {
                    secondPlayerRow = row;
                    secondPlayerCol = col;
                }
            }
        }
        return matrix;
    }
}
