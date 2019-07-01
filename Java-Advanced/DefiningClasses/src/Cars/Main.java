package Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String make = data[0];


            if (data.length > 1){
                String model = data[1];
                int horsepower = Integer.parseInt(data[2]);
                Car car = new Car(make, model, horsepower);
                cars.add(car);
            } else {
                Car car = new Car(make);
                cars.add(car);
            }


        }

        cars.forEach(c -> System.out.println(c.carInfo()));

    }
}
