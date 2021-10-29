package abstraction.zad1.app;

import abstraction.zad1.logic.ShapeCalculator;
import abstraction.zad1.model.Shape;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class App {

    public static void main(String[] args) {

        ShapeCalculator shapeCalculator = new ShapeCalculator();
        Shape shape = null;

        boolean readComplete = false;

        ShapeCalculator shapeCalc;
        while (!readComplete) {
            try {
                shape = shapeCalculator.createShape();
                readComplete = true;
            } catch (InputMismatchException e) {
                System.out.println("Wprowadziłeś dane w złym formacie, spróbuj ponownie");
            } catch (NoSuchElementException e) {
                System.out.println("Wybrany identyfikator kształtu jest niepoprawny, spróbuj ponownie");
            } finally {
                shapeCalculator.clearBuffer();
            }
        }

        System.out.println(shape);
        shapeCalculator.closeScanner();
    }


}

