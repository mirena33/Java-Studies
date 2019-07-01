import java.util.Scanner;

public class examPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int poorGrades = Integer.parseInt(scanner.nextLine());
        double sumScore = 0;
        int counter = 0;
        String lastProblem = "";
        int poorGradesCounter = 0;

        while (true) {
            String examName = scanner.nextLine();

            if ("Enough".equals(examName)) {

                System.out.printf("Average score: %.2f%n", sumScore / counter);
                System.out.printf("Number of problems: %d%n", counter);
                System.out.printf("Last problem: %s%n", lastProblem);
                return;

            }
            int grade = Integer.parseInt(scanner.nextLine());
            sumScore += grade;
            counter++;
            lastProblem = examName;

            if (grade <= 4) {
                poorGradesCounter++;
            }
            if (poorGradesCounter == poorGrades) {
                System.out.printf("You need a break, %d poor grades.", poorGradesCounter);
                break;
            }

        }


    }
}
