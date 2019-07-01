package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;


    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car) {

        String message;

        if (this.cars.containsKey(car.getRegistrationNumber())) {
            message = "Car with that registration number already exists!";
        } else if (this.cars.size() >= this.capacity) {
            message = "Parking is full!";
        } else {
            this.cars.put(car.getRegistrationNumber(), car);
            message = String.format("Successfully added new car %s %s",
                    car.getMake(), car.getRegistrationNumber());
        }

        return message;
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public String removeCar(String registrationNumber) {

        String message;

        if (!this.cars.containsKey(registrationNumber)) {

            message = "Car with that registration number, doesn't exists!";

        } else {

            this.cars.remove(registrationNumber);
            message = "Successfully removed " + registrationNumber;
        }

        return message;

    }

    public int getCount() {
        return this.cars.size();
    }

    public void removeSetOfRegistrationNumber(List<String> regNumbs) {

        for (String rm : regNumbs) {
            this.removeCar(rm);
        }

    }
}
