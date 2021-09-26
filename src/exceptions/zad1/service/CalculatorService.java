package exceptions.zad1.service;


import exceptions.zad1.exceptions.DivideByZero;
import exceptions.zad1.exceptions.UnknownOperatorException;
import exceptions.zad1.model.MathematicalOperator;

public class CalculatorService implements CalculatorInterface {

    @Override
    public double add(double... numbers) {
        double sum = 0;
        for (double value : numbers) {
            sum += value;
        }
        return sum;
    }

    @Override
    public double subtract(double... numbers) {
        double sum = 0;
        for (double value : numbers) {
            sum -= value;
        }
        return sum;
    }

    @Override
    public double multiply(double... numbers) {
        double sum = 1;
        for (double value : numbers) {
            sum *= value;
        }
        return sum;
    }

    @Override
    public double divide(double... numbers) {
        double sum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new DivideByZero("The divisor is 0.");
            }
            sum /= numbers[i];
        }
        return sum;
    }

    public double result(String operator, double... numbers) {
        double result;
        MathematicalOperator mathematicalOperator = MathematicalOperator.valueOf(operator);
        switch (mathematicalOperator) {
            case ADD -> {
                result = add(numbers);
                System.out.println("Addition result: " + result);
            }
            case SUBTRACT -> {
                result = subtract(numbers);
                System.out.println("Subtraction result: " + result);
            }
            case MULTIPLY -> {
                result = multiply(numbers);
                System.out.println("Multiplication result: " + result);
            }
            case DIVIDE -> {
                result = divide(numbers);
                System.out.println("Dividing result: " + result);
            }
            default -> throw new UnknownOperatorException("Incorrect mathematical operator. " +
                    "Enter ADD, SUBTRACT, MULTIPLY, DIVIDE");
        }
        return result;
    }
}
