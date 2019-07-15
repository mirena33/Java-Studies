package animals;

public class Dog extends Animal {
    private final static String DJAAF = "DJAAF";

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.baseExplain() + DJAAF;
    }
}
