import org.junit.Assert;
import org.junit.Test;

public class BankAccountTests {

    @Test
    public void depositShouldAddMoney() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(50);
        Assert.assertEquals(50, bankAccount.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositNegativeShouldNotAddMoney() {
        BankAccount account = new BankAccount();
        account.deposit(-50);
    }

}
