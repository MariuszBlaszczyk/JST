package packagingtypes.zad2.main;

import java.util.Scanner;

public class App {

    static String textFromUser() {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadź tekst:");
        return scan.nextLine();
    }

    static int countDigits(String userText) {
        char[] chars = userText.toCharArray();
        int counter = 0;
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                counter++;
            }
        }
        return counter;
    }

    static int countLetters(String userText) {
        char[] chars = userText.toCharArray();
        int counter = 0;
        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                counter++;
            }
        }
        return counter;
    }

    private static int findBiggest(String word) {
        char[] chars = word.toCharArray();
        final int notFound = -1;
        int biggestNumber = notFound;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                int digit = Character.getNumericValue(aChar);
                biggestNumber = Integer.max(biggestNumber, digit);
            }
        }
        if (biggestNumber == notFound)
            throw new DigitNotFoundException();
        return biggestNumber;
    }

    public static void main(String[] args) {

        String userText = textFromUser();
        int countDigits = countDigits(userText);
        System.out.println("Digits: " + countDigits);
        int countLetters = countLetters(userText);
        System.out.println("Letters: " + countLetters);
        try {
            int biggest = findBiggest(userText);
            System.out.println("Big: " + biggest);
        } catch (DigitNotFoundException e) {
            System.out.println("Nie ma cyfry w tekście");
        }
    }


    private static class DigitNotFoundException extends RuntimeException {
    }
}
