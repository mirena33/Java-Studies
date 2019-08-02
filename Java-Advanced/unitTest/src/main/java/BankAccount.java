import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    List<Double> money;

    public BankAccount() {
        this.money = new ArrayList<>();
    }

    public void deposit(double value) {
        if (value < 0){
            throw new IllegalArgumentException("Invalid input");
        }
        money.add(value);
    }

    public double getBalance() {
        return money.stream().mapToDouble(s -> s).sum();
    }
}
