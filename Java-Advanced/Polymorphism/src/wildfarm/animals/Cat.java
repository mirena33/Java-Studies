package wildfarm.animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String baseToString =  super.toString();

        int index = baseToString.indexOf(",");
        StringBuilder builder = new StringBuilder(baseToString);
        builder.insert(index + 2, this.breed + ", ");

        return builder.toString();
    }
}
