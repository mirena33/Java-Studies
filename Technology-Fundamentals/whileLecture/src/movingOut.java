import java.util.Scanner;

public class movingOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int w = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int cubicMeters = h*l*w;
        boolean check = true;

        while (!input.equals("Done")) {
            int box = Integer.parseInt(input);

            if ((cubicMeters - box) < 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(cubicMeters - box));
                check = false;
                break;
            }
            cubicMeters -= box;
            input = scanner.nextLine();

        }

        if (check) {
            System.out.println(cubicMeters + " Cubic meters left.");
        }
    }
}
