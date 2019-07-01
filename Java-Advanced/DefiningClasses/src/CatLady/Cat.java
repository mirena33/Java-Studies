package CatLady;

public abstract class Cat {
    private String name;
    private double skillValue;

    public Cat(){

    }

    public Cat(String name, double skillValue) {
        this.name = name;
        this.skillValue = skillValue;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f", this.name, this.skillValue);
    }
}
