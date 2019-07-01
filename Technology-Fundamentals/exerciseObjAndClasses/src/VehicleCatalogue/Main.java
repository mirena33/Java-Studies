package VehicleCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));

        List<Vehicle> vehicles = new ArrayList<>();
        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehicles.add(vehicle);
        }

        String model = reader.readLine();

        while (!"Close the Catalogue".equals(model)) {
            String finalModel = model;

            vehicles
                    .stream().filter(v -> v.getModel().equals(finalModel))
                    .forEach(System.out::println);


            model = reader.readLine();
        }


        Double cars = average
                (vehicles
                        .stream()
                        .filter(v -> v.getType().equals("car"))
                        .collect(Collectors.toList()));


        Double trucks = average
                (vehicles.stream()
                        .filter(v -> v.getType().equals("truck"))
                        .collect(Collectors.toList()));

        System.out.println(String.format("Cars have average horsepower of: %.2f.", cars));
        System.out.println(String.format("Trucks have average horsepower of: %.2f.",trucks));

    }

    public static double average(List<Vehicle> vehicles) {

        if (vehicles.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsepower();
        }
        return sum / vehicles.size();
    }
}
