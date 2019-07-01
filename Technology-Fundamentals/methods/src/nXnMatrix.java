import java.util.Scanner;

public class nXnMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            matrix(n);
            System.out.println();
        }
    }
    
    
    static void matrix(int n) {
        for (int i = 0; i < n ; i++) {
            System.out.printf("%d ", n);
        }
    }
}
