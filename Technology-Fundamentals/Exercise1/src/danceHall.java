import java.util.Scanner;

public class danceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double sidewardrobe = Double.parseDouble(scanner.nextLine());

        double areahall = (length * 100) * (width * 100);
        double areawardrobe = (sidewardrobe*100) * (sidewardrobe*100);
        double areapeika = areahall / 10;

        double freespace = areahall - (areapeika + areawardrobe);
        int dancers = (int)(freespace / (40 + 7000));

        System.out.println(dancers);


    }
}
