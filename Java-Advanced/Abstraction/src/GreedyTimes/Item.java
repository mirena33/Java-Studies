package GreedyTimes;

public abstract class Item {
    private long quantity;

    protected Item(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }

}
