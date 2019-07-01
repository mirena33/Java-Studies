package RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String data[] = scanner.nextLine().split("\\s+");

            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            List<Tire> tires = new LinkedList<>();

            for (int j = 5; j < data.length; j += 2) {

                double pressure = Double.parseDouble(data[j]);
                int age = Integer.parseInt(data[j + 1]);
                tires.add(new Tire(pressure, age));
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            cars.add(new Car(model, engine, cargo, tires));

        }


        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            cars.stream()
                    .filter(e -> e.getCargo().getType().equals("fragile"))
                    .filter(s -> s.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(x -> System.out.println(x.getModel()));
        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(e -> e.getCargo().getType().equals("flamable"))
                    .filter(s -> s.getEngine().getPower() > 250)
                    .forEach(x -> System.out.println(x.getModel()));
        }
    }
}
