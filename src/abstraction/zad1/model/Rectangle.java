package abstraction.zad1.model;

public class Rectangle implements Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectangle, ");
        sb.append("side A: " + a + ", ");
        sb.append("side B: " + b + ", ");
        sb.append("area: " + calculateArea() + ", ");
        sb.append("perimeter: " + calculatePerimeter());
        return sb.toString();
    }
}
