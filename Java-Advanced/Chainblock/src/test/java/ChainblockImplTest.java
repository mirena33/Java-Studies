import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private static final int ID = 1;
    private static final TransactionStatus SUCCESSFUL_STATUS = TransactionStatus.SUCCESSFUL;
    private static final String SENDER = "Pesho";
    private static final String RECEIVER = "Gosho";
    private static final double INITIAL_AMOUNT = 100.00;

    private static final int[] IDS = {1, 2, 3, 4, 5, 6};
    private static final String[] NAMES = {"A", "B", "C", "D", "E", "F"};
    private static final int[] AMOUNTS = {10, 20, 30, 40, 50, 60};


    private static final Transaction TRANSACTION_ID_ONE = new TransactionImpl(
            ID, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT);

    @Before
    public void createChainblock() {
        this.chainblock = new ChainblockImpl();
    }

    @Test
    public void containsByIdReturnsTrueIfTransactionsIsPresent() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        Assert.assertTrue(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void containsByIdReturnsFalseIfTransactionsIsNotPresent() {
        Assert.assertFalse(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void addShouldIncreaseCount() {
        final int expectedCount = 1;
        this.chainblock.add(TRANSACTION_ID_ONE);
        Assert.assertEquals(this.chainblock.getCount(), expectedCount);
    }

    @Test
    public void containsByTransactionShouldReturnTrueIfTransactionIsPresent() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        Assert.assertTrue(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void getCountShouldReturnZeroOnEmptyCollection() {
        Assert.assertEquals(this.chainblock.getCount(), 0);
    }

    @Test
    public void getCountShouldReturnOneWhenAddingTheSameElementMultipleTimes() {
        for (int i = 0; i < 10; i++) {
            this.chainblock.add(TRANSACTION_ID_ONE);
        }
        Assert.assertEquals(this.chainblock.getCount(), 1);
    }

    @Test
    public void getCountShouldWorkProperlyWithMultipleElements() {
        final int ELEMENTS_COUNT = 10;

        for (int i = 1; i <= 10; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT + 20.5));
        }
        Assert.assertEquals("Adding multiple transactions does not increase count",
                ELEMENTS_COUNT, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changingStatusShouldThrowExceptionWithInvalidTransactionID() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        TransactionStatus newStatus =
                TransactionStatus.values()[(TransactionStatus.SUCCESSFUL.ordinal() + 1) % TransactionStatus.values().length];
        this.chainblock.changeTransactionStatus(ID + 1, newStatus);
    }

    @Test
    public void changingStatusShouldWorkCorrectly() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        TransactionStatus newStatus =
                TransactionStatus.values()[(TransactionStatus.SUCCESSFUL.ordinal() + 1) % TransactionStatus.values().length];
        this.chainblock.changeTransactionStatus(ID, newStatus);

        Assert.assertEquals(newStatus, TRANSACTION_ID_ONE.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeByIdShouldThrowExceptionWithInvalidID() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        this.chainblock.removeTransactionById(ID + 1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeByIdShouldThrowExceptionOnEmptyCollection() {
        new ChainblockImpl().removeTransactionById(ID);
    }

    @Test
    public void removeByIDShouldWorkCorrectly() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        this.chainblock.removeTransactionById(ID);
        Assert.assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void removeByIDShouldRemoveTheCorrectTransaction() {
        final int ELEMENTS_COUNT = 10;
        for (int i = 1; i <= 10; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT + 20.5));
        }
        this.chainblock.removeTransactionById(ELEMENTS_COUNT - 1);
        Assert.assertFalse(this.chainblock.contains(ELEMENTS_COUNT - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExceptionOnEmptyCollection() {
        new ChainblockImpl().getById(ID);
    }

    @Test
    public void getByIDShouldReturnTheCorrectTransactionWithSingleElement() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        Transaction returnedTransaction = this.chainblock.getById(TRANSACTION_ID_ONE.getId());
        Assert.assertEquals(TRANSACTION_ID_ONE.getId(), returnedTransaction.getId());
    }

    @Test
    public void getByIDShouldReturnTheCorrectTransaction() {
        final int ELEMENTS_COUNT = 10;

        for (int i = 1; i <= 10; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT + 20.5));
        }
        Transaction returnedTransaction = this.chainblock.getById(ELEMENTS_COUNT - 1);
        Assert.assertEquals(ELEMENTS_COUNT - 1, returnedTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTransactionsByStatusShouldThrowExceptionIfThereAreNoTransactionWithGivenStatus() {
        final int ELEMENTS_COUNT = 10;

        for (int i = 1; i <= ELEMENTS_COUNT; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT + 20.5));
        }

        this.chainblock.getByTransactionStatus
                (TransactionStatus.values()[(TransactionStatus.SUCCESSFUL.ordinal() + 1) % TransactionStatus.values().length]);
    }

    @Test
    public void getTransactionsByStatusShouldReturnAllTransactionsWithGivenStatus() {
        final int ELEMENTS_COUNT = 9;

        for (int i = 1; i <= ELEMENTS_COUNT; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT + 20.5));
        }

        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(SUCCESSFUL_STATUS);
        int count = 0;
        for (Transaction transaction : transactions) {
            count++;
        }
        Assert.assertEquals(ELEMENTS_COUNT, count);
    }

    @Test
    public void getTransactionsByStatusShouldReturnAllTransactionsWithGivenStatusInDescendingOrderByAmount() {
        final int ELEMENTS_COUNT = 9;

        for (int i = 1; i <= ELEMENTS_COUNT; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT * i));
        }

        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(SUCCESSFUL_STATUS);

        boolean areOrdered = true;
        double amount = Double.POSITIVE_INFINITY;

        for (Transaction transaction : transactions) {
            if (amount < transaction.getAmount()) {
                areOrdered = false;
                break;
            } else {
                amount = transaction.getAmount();
            }
        }
        Assert.assertTrue(areOrdered);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowExceptionWhenNoTransactionsWithGivenStatusArePresent() {
        final int ELEMENTS_COUNT = 20;

        for (int i = 1; i <= ELEMENTS_COUNT; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT * i));
        }

        this.chainblock.getAllSendersWithTransactionStatus
                (TransactionStatus.values()[(TransactionStatus.SUCCESSFUL.ordinal() + 1) % TransactionStatus.values().length]);

    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnCorrectNames() {
        for (int i = 0; i < IDS.length; i++) {
            this.chainblock.add(new TransactionImpl(IDS[i], SUCCESSFUL_STATUS, NAMES[i], NAMES[i], AMOUNTS[i]));
        }

        Iterable<String> senders = this.chainblock.getAllSendersWithTransactionStatus(SUCCESSFUL_STATUS);

        int index = NAMES.length - 1;
        boolean areEqual = true;
        for (String sender : senders) {
            if (!sender.equals(NAMES[index--])) {
                areEqual = false;
                break;
            }
        }
        Assert.assertTrue(areEqual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowExceptionWhenNoTransactionsWithGivenStatusArePresent() {
        final int ELEMENTS_COUNT = 20;

        for (int i = 1; i <= ELEMENTS_COUNT; i++) {
            this.chainblock.add(new TransactionImpl(
                    i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT * i));
        }

        this.chainblock.getAllReceiversWithTransactionStatus
                (TransactionStatus.values()[(TransactionStatus.SUCCESSFUL.ordinal() + 1) % TransactionStatus.values().length]);

    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnCorrectNames() {
        for (int i = 0; i < IDS.length; i++) {
            this.chainblock.add(new TransactionImpl(IDS[i], SUCCESSFUL_STATUS, NAMES[i], NAMES[i], AMOUNTS[i]));
        }

        Iterable<String> senders = this.chainblock.getAllReceiversWithTransactionStatus(SUCCESSFUL_STATUS);

        int index = NAMES.length - 1;
        boolean areEqual = true;
        for (String sender : senders) {
            if (!sender.equals(NAMES[index--])) {
                areEqual = false;
                break;
            }
        }
        Assert.assertTrue(areEqual);
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnSortedElements() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, "A", "B", 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, "A", "B", 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, "A", "B", 100);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, "A", "B", 200);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);

        Iterable<Transaction> ordered = this.chainblock.getAllOrderedByAmountDescendingThenById();
        int[] expectedIDS = {4, 2, 1, 3};
        int index = 0;

        for (Transaction transaction : ordered) {
            Assert.assertEquals(expectedIDS[index++], transaction.getId());
        }
        Assert.assertEquals(expectedIDS.length, index);
    }

}
