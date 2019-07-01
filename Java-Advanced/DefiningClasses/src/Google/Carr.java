package Google;

public class Carr {
    private String model;
    private int speed;

    public Carr(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Carr() {
        this.model = "";
        this.speed = -1;
    }

    @Override
    public String toString() {
        return this.model.equals("") ? "Car:" :
                String.format("Car:%n%s %d", this.model, this.speed);
    }
}