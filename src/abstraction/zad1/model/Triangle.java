package abstraction.zad1.model;

public class Triangle implements Shape {

    private double height;
    private double a;
    private double b;
    private double c;

    public Triangle(double height, double a, double b, double c) {
        this.height = height;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        return a * height / 2;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Triangle, ");
        sb.append("side A: " + a + ", ");
        sb.append("side B: " + b + ", ");
        sb.append("side C: " + c + ", ");
        sb.append("height (A side): " + height + ", ");
        sb.append("area: " + calculateArea() + ", ");
        sb.append("perimeter: " + calculatePerimeter());
        return sb.toString();
    }
}
