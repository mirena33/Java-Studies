package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {

        if (this.getOxygen() - 10 >= 0) {
            this.setOxygen(this.getOxygen() - 10);
        } else {
            this.setOxygen(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_ASTRONAUT_NAME, this.getName()))
                .append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, this.getOxygen()))
                .append(System.lineSeparator())
                .append("Bag items: ");

        if (this.getBag().getItems().isEmpty()) {
            sb.append("none").append(System.lineSeparator());
        } else {
            for (String item : this.getBag().getItems()) {
                sb.append(item).append(", ");

            }

        }
        return sb.toString().trim();
    }
}
