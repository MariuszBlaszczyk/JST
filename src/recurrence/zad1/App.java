package recurrence.zad1;

public class App {

    static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be higher them 0!");
        }
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
        // return n==0 || n==1 ? 1 : number * factorial(number - 1);
    }

    public static void main(String[] args) {

        int factArg = 5;
        int result = factorial(factArg);

        System.out.println("Silnia " + factArg + " = " + result);
    }
}
