package GreedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private long capacity;
    private List<List<Item>> items;


    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();

        this.items.add(new ArrayList<>());
        this.items.add(new ArrayList<>());
        this.items.add(new ArrayList<>());
    }

    public long getCapacity() {
        return this.capacity;
    }

    public void addGem(String name, long quantity) {

        if (this.getItemAmount(0) >= this.getItemAmount(1) + quantity) {

            this.capacity -= quantity;
            Item item = new Gem(name, quantity);
            this.items.get(1).add(item);
        }
    }


    public void addCash(String name, long quantity) {

        if (this.getItemAmount(1) >= this.getItemAmount(2) + quantity) {

            this.capacity -= quantity;
            Item item = new Cash(name, quantity);
            this.items.get(2).add(item);
        }

    }

    private long getItemAmount(int index) {
        return this.items.get(index).stream().mapToLong(Item::getQuantity).sum();
    }

    public void addGold(long quantity) {
        if (this.items.get(0).size() == 0) {
            this.items.get(0).add(new Gold(quantity));
        } else {
            this.items.get(0).get(0).addQuantity(quantity);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.items.get(0).get(0).toString()).append(System.lineSeparator());

        if (this.getItemAmount(0) != 0) {
            builder.append("##Gold - ").append(this.getItemAmount(0)).append(System.lineSeparator());
        }

        long gemsAmount = this.getItemAmount(1);

        builder.append(String.format("<Gem> $%d", gemsAmount)).append(System.lineSeparator());

        if (gemsAmount != 0) {
            this.items.get(1).forEach(item -> {
                builder.append(item.toString()).append(System.lineSeparator());
            });
        }

        long cashAmount = this.getItemAmount(2);

        builder.append(String.format("<Cash> $%d", cashAmount)).append(System.lineSeparator());

        if (cashAmount != 0) {
            this.items.get(2).forEach(item -> {
                builder.append(item.toString()).append(System.lineSeparator());
            });
        }

        return builder.toString();
    }
}
