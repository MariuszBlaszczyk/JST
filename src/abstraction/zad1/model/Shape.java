package abstraction.zad1.model;

public interface Shape {

    int RECTANGLE = 1;
    int CIRCLE = 2;
    int TRIANGLE = 3;

    double PI = Math.PI;

    double calculateArea();

    double calculatePerimeter();

}
