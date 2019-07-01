import java.util.Scanner;

public class bonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        double bonusPoints = 0.0;

        if (number <= 100) {
            bonusPoints = 5;
        }
        else if (number <= 1000) {
            bonusPoints = number * 0.2;
        }
        else if (number > 1000) {
            bonusPoints = number * 0.1;
        }

        if (number % 2 == 0) {
            bonusPoints++;
        }
        else if (number % 10 == 5) {
            bonusPoints += 2;
        }

        System.out.println(bonusPoints);
        System.out.println(number + bonusPoints);

    }

}


