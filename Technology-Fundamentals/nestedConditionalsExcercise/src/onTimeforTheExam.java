import java.util.Scanner;

public class onTimeforTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMin = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMin;
        int arrivalTime = arrivalHour * 60 + arrivalMin;

        int result =arrivalTime - examTime;

        if (result > 0) {
            System.out.println("Late");
            if (result < 60) {System.out.printf("%d minutes after the start", result);
            } else if (result >= 60) {
                System.out.printf("%d:%02d hours after the start", result/60, result%60);
            }

        } else if (result <= 0 && result >= -30) {
            System.out.println("On time");
            if (result<0) {
                System.out.printf("%d minutes before the start", Math.abs(result));
            }
        } else if (result < - 30) {
            System.out.println("Early");
            if (result > -60) {
                System.out.printf("%d minutes before the start", Math.abs(result));
            } else if (result <= -60) {
                System.out.printf("%d:%02d hours before the start", Math.abs(result/60), Math.abs(result%60));
            }
        }



    }
}
