import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] INITIAL_ELEMENTS = {
            13, 42, 69, 73
    };

    private static final Integer[] INVALID_MAX_ELEMENTS = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18
    };

    @Test
    public void creatingDatabaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        Assert.assertArrayEquals(db.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(INVALID_MAX_ELEMENTS);
    }

    @Test
    public void addingElementShouldAddCorrectly() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        db.add(17);
        Assert.assertEquals(db.getElements().length, INITIAL_ELEMENTS.length + 1);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowAnException() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabaseShouldThrowAnException() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        for (int i = 0; i < INITIAL_ELEMENTS.length; i++) {
            db.remove();
        }
        db.remove();
    }

    @Test
    public void removeShouldDecreaseElementsCount() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        db.remove();
        Assert.assertEquals(db.getElements().length,
                INITIAL_ELEMENTS.length - 1);

    }
}
