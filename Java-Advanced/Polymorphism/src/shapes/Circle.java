package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * Math.PI * this.radius;
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = Math.PI * Math.pow(this.radius, 2);
        super.setArea(result);
    }

    public final Double getRadius() {
        return radius;
    }
}
