package abstraction.zad1.model;

public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double calculateArea() {
        return Shape.PI * r * r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Shape.PI * r;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Circle, ");
        sb.append("radius: " + r + ", ");
        sb.append("area: " + calculateArea() + ", ");
        sb.append("perimeter: " + calculatePerimeter());
        return sb.toString();
    }
}
