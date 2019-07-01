import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long sum = CalcFactorial(n);

        System.out.println(sum);
    }

    private static long CalcFactorial(int n) {
        if (n == 1){
            return 1;
        }

        return n * CalcFactorial(n - 1);
    }

}
