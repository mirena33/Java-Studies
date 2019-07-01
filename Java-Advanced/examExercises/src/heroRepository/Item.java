package heroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Item:")
                .append(System.lineSeparator())
                .append(String.format("  *  Strength: %d%n", this.strength))
                .append(String.format("  *  Agility: %d%n", this.agility))
                .append(String.format("  *  Intelligence: %d", this.intelligence));

        return sb.toString().trim();
    }
}
