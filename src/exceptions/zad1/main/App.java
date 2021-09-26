package exceptions.zad1.main;


import exceptions.zad1.service.CalculatorService;
import exceptions.zad1.service.IO;

public class App {

    public static void main(String[] args) {

        System.out.println("Enter the first number:");
        double userNumber1 = IO.getNumberFromUser();
        System.out.println("Enter ADD, SUBTRACT, MULTIPLY, DIVIDE");
        String operator = IO.getMathematicalOperator();
        System.out.println("Enter the second number:");
        double userNumber2 = IO.getNumberFromUser();

        CalculatorService cs = new CalculatorService();
        double result = cs.result(operator, userNumber1, userNumber2);


    }
}
