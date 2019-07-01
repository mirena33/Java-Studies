import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] allPeople = new int[n];

        for (int i = 0; i < n; i++) {
          allPeople[i] = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;

        for (int j = 0; j < allPeople.length; j++) {

            System.out.print(allPeople[j] + " ");
            sum += allPeople[j];
        }

        System.out.println();
        System.out.println(sum);
    }
}
