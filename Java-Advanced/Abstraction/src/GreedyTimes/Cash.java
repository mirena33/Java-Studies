package GreedyTimes;

public class Cash extends Item {
    private String name;

    public Cash(String name, long quantity) {
        super(quantity);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.name, this.getQuantity());
    }

}
