package heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;


    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s - %d%n",
                this.getName(), this.getLevel()));

        sb.append(String.format("  *  Strength: %d%n", this.getItem().getStrength()))
                .append(String.format("  *  Agility: %d%n", this.getItem().getAgility()))
                .append(String.format("  *  Intelligence: %d", this.getItem().getIntelligence()));

        return sb.toString().trim();
    }
}
