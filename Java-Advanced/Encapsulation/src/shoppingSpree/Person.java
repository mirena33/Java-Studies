package shoppingSpree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public boolean validatePurchase(Product product) {
        boolean check;

        if (money >= product.getCost()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public void buyProduct(Product product) {
        this.products.add(product);
        this.setMoney(money - product.getCost());

    }

    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {

        return String.format("%s - %s", this.getName(),
                (this.getProducts().size() > 0) ? this.getProducts().toString().replaceAll("[\\[\\]]", "") :
                        "Nothing bought");
    }
}
