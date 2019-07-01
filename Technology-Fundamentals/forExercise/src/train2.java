import java.util.Scanner;

public class train2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teamName = scanner.nextLine();
        int playedMatches = Integer.parseInt(scanner.nextLine());
        int durationSum = 0;
        int additionalTime = 0;
        int penalties = 0;


        for (int i = 0; i < playedMatches; i++) {
            int matchDuration = Integer.parseInt(scanner.nextLine());
            durationSum += matchDuration;

            if (matchDuration > 120) {
                penalties++;
            } else if (matchDuration > 90) {
                additionalTime++;
            }

        }
        double average = durationSum * 1.00 / playedMatches;

        System.out.printf("%s has played %d minutes. " +
                "Average minutes per game: %.2f\n", teamName, durationSum, average);

        System.out.println("Games with penalties: " + penalties);
        System.out.println("Games with additional time: " + additionalTime);
    }
}
