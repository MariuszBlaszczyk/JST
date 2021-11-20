package lists.zad1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);
    private static final String EXIT = "exit";

    private static void printList(List<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        for (Double d : numbers) {

            sb.append(d);
            sb.append(" + ");
            sum += d;
        }
        sb.replace(sb.length() - 1, sb.length(), " = ");
        sb.append(sum);
        System.out.println(sb);
    }

    private static void fillList(List<Double> numbers) {
        System.out.println("Enter a number, or type the word exit");
        String input = scan.nextLine();

        if (input.equals(EXIT.toLowerCase())) {
            return;
        }
        try {
            Double value = Double.valueOf(input);
            numbers.add(value);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        fillList(numbers);
    }

    public static void main(String[] args) {

        List<Double> numbers = new ArrayList<>();
        fillList(numbers);
        printList(numbers);
    }


}
