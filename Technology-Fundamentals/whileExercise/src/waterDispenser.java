import java.util.Scanner;

public class waterDispenser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cupVolume = Integer.parseInt(scanner.nextLine());
        int pouredWater = 0;
        String command = scanner.nextLine();
        int counter = 0;

        while (cupVolume > 0) {
            counter++;
            switch (command) {
                case "Easy": pouredWater += 50;
                    break;
                case  "Medium": pouredWater += 100;
                    break;
                case "Hard": pouredWater += 200;
                    break;
            }
            if (pouredWater == cupVolume) {
                System.out.printf("The dispenser has been tapped %d times.", counter);
                return;
            } else if (pouredWater > cupVolume) {
                int spilledWater = pouredWater - cupVolume;
                System.out.printf("%dml has been spilled.", spilledWater);
                return;
            }
            command = scanner.nextLine();

        }
    }
}
