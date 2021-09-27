package exceptions.zad1.service;

import exceptions.zad1.exceptions.UnknownOperatorException;

import java.util.Scanner;

public class IO {

    public static double getNumberFromUser() {
        final Scanner scanner = new Scanner(System.in);
        String userText = "";
        double userNumber = 0;
        String regex = "([-]?\\d)*\\.?\\d*";
        do {
            try {
                userNumber = Double.parseDouble(userText = scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("You have given an incorrect value, please provide a number.");
                scanner.nextLine();
            }
        } while (!userText.matches(regex));
        return userNumber;
    }

    public static String getMathematicalOperator() {
        final Scanner scanner = new Scanner(System.in);
        String userText = "";
        String regex = "(ADD|SUBTRACT|MULTIPLY|DIVIDE)";
        do {
            try {
                userText = scanner.next().toUpperCase();
            } catch (UnknownOperatorException e) {
                System.out.println("Incorrect mathematical operator. " +
                        "Enter ADD, SUBTRACT, MULTIPLY, DIVIDE");
            }
        } while (!userText.matches(regex));
        return userText;
    }
}
