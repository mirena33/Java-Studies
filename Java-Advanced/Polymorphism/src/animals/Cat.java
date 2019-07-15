package animals;

public class Cat extends Animal {
    private final static String MEOW = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return super.baseExplain() + MEOW;
    }
}
