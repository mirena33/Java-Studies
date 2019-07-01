import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        char a = 'a';
        char b = 'a';

        for (int r = 0; r < matrix.length; r++) {


            for (int c = 0; c < matrix[r].length; c++) {

                System.out.print(a);
                System.out.print(b);
                System.out.print(a);
                System.out.print(" ");
                b++;

            }

            System.out.println();
            a++;
            b = a;
        }
    }
}
