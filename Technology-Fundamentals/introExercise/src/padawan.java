import java.util.Scanner;

public class padawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double pricePerSabre = Double.parseDouble(scanner.nextLine());
        double pricePerRobe = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        int freeBelts = 0;

        if (students >= 6) {
            freeBelts = students / 6;
        }

        double sum = pricePerSabre * (Math.ceil(students * 0.1) + students) + pricePerRobe * students
                + pricePerBelt * (students - freeBelts);

        if (sum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", sum - budget);
        }
    }
}
