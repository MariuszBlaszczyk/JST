package abstraction.zad1.logic;

import abstraction.zad1.model.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShapeCalculator {

    private Scanner input = new Scanner(System.in);


    public void closeScanner() {
        input.close();
    }

    private Rectangle readRectangleData() {
        System.out.println("Podaj informacje o prostokącie.");
        System.out.println("Podaj długość boku A:");
        double a = input.nextDouble();
        System.out.println("Podaj długość boku B:");
        double b = input.nextDouble();

        return new Rectangle(a, b);
    }

    private Circle readCircleData() {
        System.out.println("Podaj informacje o kole.");
        System.out.println("Podaj długość promienia:");
        double r = input.nextDouble();

        return new Circle(r);
    }

    private Triangle readTriangleData() {
        System.out.println("Podaj informacje o trójkat.");
        System.out.println("Podaj długość boku A:");
        double a = input.nextDouble();
        System.out.println("Podaj długość boku B:");
        double b = input.nextDouble();
        System.out.println("Podaj długość boku C:");
        double c = input.nextDouble();
        System.out.println("Podaj wysokość:");
        double h = input.nextDouble();

        return new Triangle(a, b, c, h);
    }

    private void printOption() {
        System.out.println("Choose a figure:");
        for (ShapeChoose shape : ShapeChoose.values()) {
            System.out.println(shape.name() + ", choose: " + shape.ordinal() + ".");
        }
    }

    private ShapeChoose chooseOption() {
        int userChoose = input.nextInt();
        ShapeChoose sc = ShapeChoose.fromValue(userChoose);
        return sc;
    }

    public Shape createShape() {
        printOption();
        ShapeChoose choose = chooseOption();
        switch (choose) {
            case RECTANGLE -> {
                return readRectangleData();
            }
            case CIRCLE -> {
                return readCircleData();
            }
            case TRIANGLE -> {
                return readTriangleData();
            }
            default -> throw new NoSuchElementException();
        }
    }

    public void clearBuffer() {
        input.nextLine();
    }
}
