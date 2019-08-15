package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceEntryTest {
    private RaceEntry raceEntry;

    @Before
    public void initRaceEntry() {
        this.raceEntry = new RaceEntry();
    }

    @Test(expected = NullPointerException.class)
    public void addingRiderWithNullValueShouldThrowException() {
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingTheSameUnitRiderShouldThrowException() {
        UnitRider rider = new UnitRider("Stancho", null);
        this.raceEntry.addRider(rider);
        this.raceEntry.addRider(rider);
    }

    @Test
    public void addingShouldReturnCorrectMessage() {
        UnitRider rider = new UnitRider("Stancho", null);
        String result = this.raceEntry.addRider(rider);
        String expected = "Rider Stancho added in race.";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void addingShouldIncreaseSize() {
        UnitRider rider = new UnitRider("Stancho", null);
        this.raceEntry.addRider(rider);
        Assert.assertEquals(1, this.raceEntry.getRiders().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionIfParticipantsNotEnough() {
        UnitRider rider = new UnitRider("Stancho", new UnitMotorcycle("Yamaha", 20, 450));
        this.raceEntry.addRider(rider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePowerShouldWorkCorrectly() {
        UnitRider rider = new UnitRider("Stancho", new UnitMotorcycle("Yamaha", 20, 450));
        UnitRider riderTwo = new UnitRider("Stancho2", new UnitMotorcycle("Yamaha", 20, 450));
        this.raceEntry.addRider(rider);
        this.raceEntry.addRider(riderTwo);

        double expected = this.raceEntry.calculateAverageHorsePower();
        Assert.assertEquals(expected, 20, 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRidersShouldThrowExceptionIfWeTryToModify() {
        UnitRider rider = new UnitRider("Stancho", new UnitMotorcycle("Yamaha", 20, 450));
        this.raceEntry.addRider(rider);
        this.raceEntry.getRiders().clear();
    }

}
