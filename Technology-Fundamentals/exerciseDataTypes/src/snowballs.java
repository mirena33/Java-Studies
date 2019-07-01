import java.util.Scanner;

public class snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        long highestSnowballValue = 0;
        int snowballSnowMax = 0;
        int snowballTimeMax = 0;
        int snowballQualityMax = 0;

        for (int i = 0; i < N; i++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = 0;

            snowballValue = (long) Math.pow((snowballSnow / snowballTime), snowballQuality);

            if (snowballValue > highestSnowballValue) {
                highestSnowballValue = snowballValue;
                snowballSnowMax = snowballSnow;
                snowballTimeMax = snowballTime;
                snowballQualityMax = snowballQuality;

            }


        }

        System.out.printf("%d : %d = %d (%d)", snowballSnowMax, snowballTimeMax, highestSnowballValue, snowballQualityMax);
    }
}
