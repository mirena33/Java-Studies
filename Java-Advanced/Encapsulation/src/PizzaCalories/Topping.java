package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String type) {
        Validator.validateToppingType(type);
        this.toppingType = type;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(this.toppingType, weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;

        switch (this.toppingType) {
            case "Meat":
                calories *= 1.2;
                break;

            case "Veggies":
                calories *= 0.8;
                break;

            case "Cheese":
                calories *= 1.1;
                break;

            default:
                calories *= 0.9;
                break;
        }

        return calories;
    }
}
