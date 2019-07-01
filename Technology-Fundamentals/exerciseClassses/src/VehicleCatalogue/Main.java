package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        List<Vehicle> vehicles = new ArrayList<>();

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));

            vehicles.add(vehicle);
        }

        String model = scanner.nextLine();

        while (!"Close the Catalogue".equals(model)){



            model = scanner.nextLine();
        }
    }
}
