package GreedyTimes;

public class Gold extends Item {

    public Gold(long quantity) {
        super(quantity);
    }

    @Override
    public String toString() {
        return String.format("<Gold> $%d", this.getQuantity());
    }
}
