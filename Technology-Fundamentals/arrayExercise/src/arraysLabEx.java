import java.util.Scanner;

public class arraysLabEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] people = new int[n];

        int sum = 0;

        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());

            sum += people[i];

        }

        for (int i = 0; i < people.length; i++) {
            if (i < people.length - 1) {
                System.out.print(people[i] + " ");
            } else {
                System.out.print(people[i]);
            }
        }

        System.out.println("\n" + sum);

    }
}
