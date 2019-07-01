import java.util.Scanner;

public class graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double averageGrade = 0.0;
        int counter = 0;
        boolean check = false;

        while (counter < 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            counter++;
            if (grade >= 4.00) {
                averageGrade = averageGrade + grade;
                check = true;
            }

        }

        if (true) {
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade / 12);
        } else {
            System.out.printf("%s has been excluded at %f grade", name, counter);
        }
    }
}
