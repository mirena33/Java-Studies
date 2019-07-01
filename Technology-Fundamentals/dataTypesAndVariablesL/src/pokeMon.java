import java.util.Scanner;

public class pokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePowerN = Integer.parseInt(scanner.nextLine());
        int distanceBtwnTargetsM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        int remainedFromN = 0;

        while (pokePowerN > distanceBtwnTargetsM) {
            remainedFromN = pokePowerN - distanceBtwnTargetsM;
            counter++;
        }

        System.out.println(remainedFromN);
        System.out.println(counter);
    }
}
