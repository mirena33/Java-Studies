package softUniParking;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking(5);

        Car car = new Car("Skoda", "Fabia", 65, "CC1856BG");

        Car car2 = new Car("Audi", "A3", 110, "EB8787MN");

        System.out.println(car.toString());

        System.out.println(parking.addCar(car));

        System.out.println(parking.addCar(car));

        System.out.println(parking.addCar(car2));

        System.out.println(parking.getCar("EB8787MN").toString());

        System.out.println(parking.removeCar("EB8787MN"));

        System.out.println(parking.getCount()); //1

        List<String> regNums = new ArrayList<>();

        regNums.add("EB8787MN");
        regNums.add("invalid");

        parking.removeSetOfRegistrationNumber(regNums);

        System.out.println(parking.getCount());
    }


}
