package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleData = scanner.nextLine().split("\\s+");
        Vehicle car = produceVehicle(vehicleData);

        vehicleData = scanner.nextLine().split("\\s+");
        Vehicle truck = produceVehicle(vehicleData);

        vehicleData = scanner.nextLine().split("\\s+");
        Vehicle bus = produceVehicle(vehicleData);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String output = null;

            if (tokens[0].equals("Drive")) {
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else if (tokens[0].equals("Refuel")) {
                vehicles.get(tokens[1]).reFuel(Double.parseDouble(tokens[2]));
            }

            if (output != null) {
                System.out.println(output);
            }

        }

        vehicles.entrySet().forEach(e -> System.out.println(e.getValue().toString()));

    }

    public static Vehicle produceVehicle(String[] data) {
        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(
                    Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Integer.parseInt(data[3]));
        } else if (data[0].equals("Truck")) {
            vehicle = new Truck(
                    Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Integer.parseInt(data[3]));
        }

        return vehicle;
    }
}
