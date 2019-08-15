package parkingSystem;


import org.junit.Assert;
import org.junit.Test;

public class SoftParkTest {
    @Test
    public void testValidImplConstructor() {
        SoftPark park = new SoftPark();
        int actualParkCount = park.getParking().size();

        Assert.assertEquals(12, actualParkCount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getParkingMethodShouldThrowExceptionIfTryToClearUnmodifiable() {
        SoftPark softPark = new SoftPark();
        softPark.getParking().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionWhenIfTheParkSportDoesNotExist() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");
        softPark.parkCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionWhenIfTheParkSportHasBeenTaken() {
        SoftPark softPark = new SoftPark();
        Car parkedCar = new Car("Audi", "CA 5241 CA");
        Car car = new Car("BMW", "CA 5017 CA");

        softPark.parkCar("A1", parkedCar);
        softPark.parkCar("A1", car);
    }

    @Test
    public void parkCarMessageShouldWorkCorrectly() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");
        String actualCarParkRes = softPark.parkCar("A1", car);

        Assert.assertEquals("Car:CA 5241 CA parked successfully!", actualCarParkRes);

    }

    @Test
    public void parkCarShouldWorkCorrectly() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");
        String actualCarParkRes = softPark.parkCar("A1", car);

        Assert.assertEquals(car, softPark.getParking().get("A1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkSportDoesNotExist() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");
        softPark.removeCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfTheCarWeWantToRemoveDoesNotExistInTheCarSpot() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");

        softPark.parkCar("A1", car);
        softPark.removeCar("A2", car);
    }

    @Test
    public void removeCarShouldCorrectlyRemovesCarFromCollection() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");

        softPark.parkCar("A1", car);
        softPark.removeCar("A1", car);

        Assert.assertNull(softPark.getParking().get("A1"));
    }

    @Test
    public void removeCarMessageShouldWorkCorrectly() {
        SoftPark softPark = new SoftPark();
        Car car = new Car("Audi", "CA 5241 CA");

        softPark.parkCar("A1", car);
        String actualMessage = softPark.removeCar("A1", car);

        Assert.assertEquals("Remove car:CA 5241 CA successfully!", actualMessage);
    }
}