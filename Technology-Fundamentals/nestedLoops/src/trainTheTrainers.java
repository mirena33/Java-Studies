import java.util.Scanner;

public class trainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juryNum = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        double averageGrade = 0;
        double finalGrade = 0;
        int presentationCounter = 0;

        while (!"Finish".equals(presentation)) {
            for (int i = 0; i < juryNum; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                averageGrade += grade;
               ;
            }
            presentationCounter++;
            finalGrade += averageGrade / juryNum;

            System.out.printf("%s - %.2f.%n", presentation, averageGrade / juryNum);
            presentation = scanner.nextLine();
            averageGrade = 0;
        }
        System.out.printf("Student's final assessment is %.2f.", finalGrade/presentationCounter);

    }
}
