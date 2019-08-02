package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private boolean airConditioningIsOn;
    private double fuelConsumption;
    private double additionalConsumption;
    private int tankCapacity;


    protected Vehicle(double fuelQuantity, double fuelConsumption, double additionalConsumption, int tankCapacity) {

        this.setFuelQuantity(fuelQuantity);
        this.setAirConditioning(airConditioningIsOn);
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > 0) {
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioningIsOn = airConditioning;
    }

    public String drive(double distance) {
        String output = null;
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat format = new DecimalFormat("#.##");

        if (fuelNeeded <= fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;

            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    format.format(distance));
        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        return output;
    }

    public void reFuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (this.fuelQuantity + fuel <= tankCapacity) {
                this.fuelQuantity += fuel;

            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        }
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
