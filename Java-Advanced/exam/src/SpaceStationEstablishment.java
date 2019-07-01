import java.util.Scanner;

public class SpaceStationEstablishment {

    public static int otherORow;
    public static int otherOCol;
    public static int starPower;

    public static int stephanRow;
    public  static int stephanCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];



        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("S")) {
                stephanRow = i;
                stephanCol = line.indexOf("S");
            }
        }

        boolean isInVoid = false;

        while (!isInVoid && starPower <= 50) {

            String command = scanner.nextLine();

            field[stephanRow][stephanCol] = '-';

            if (command.equals("up") && isInBounds(stephanRow - 1, stephanCol, field)) {

                stephanRow--;
                moveStephan(stephanRow, stephanCol, field);
                isInVoid = isInBounds(stephanRow - 1, stephanCol, field);


            } else if (command.equals("down") && isInBounds(stephanRow + 1, stephanCol, field)) {
                stephanRow++;
                moveStephan(stephanRow, stephanCol, field);
                isInVoid = isInBounds(stephanRow + 1, stephanCol, field);

            } else if (command.equals("left") && isInBounds(stephanRow, stephanCol - 1, field)) {
                stephanCol--;
                moveStephan(stephanRow, stephanCol, field);
                isInVoid = isInBounds(stephanRow, stephanCol - 1, field);

            } else if (command.equals("right") && isInBounds(stephanRow, stephanCol + 1, field)) {
                stephanCol++;
                moveStephan(stephanRow, stephanCol, field);
                isInVoid = isInBounds(stephanRow, stephanCol + 1, field);

            }

        }

        if (isInVoid){
            System.out.println("Bad news, the spaceship went to the void.");
        }else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }

        System.out.println("Star power collected: " + starPower);

        printField(field);
    }

    private static void moveStephan(int newRow, int newCol, char[][] field) {

        char nextElement = field[newRow][newCol];

        if (Character.isDigit(nextElement)) {
            starPower += Character.getNumericValue(nextElement);

        } else if (nextElement == 'O') {
            field[stephanRow][stephanCol] = '-';
            findOtherO(field);
            stephanRow = otherORow;
            stephanCol = otherOCol;

        }

        field[stephanRow][stephanCol] = 'S';
    }

    private static void findOtherO(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'O') {
                    otherORow = r;
                    otherOCol = c;
                }
            }
        }
    }

    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static void printField(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
