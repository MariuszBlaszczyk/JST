package arraysclass.zad2;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class App {

    static String userText() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    static boolean stringEquals(String text1, String text2) {
        if (text1.isEmpty() || text1.isBlank()) {
            throw new IllegalArgumentException("Text is blank or empty");
        }
        if (text1.isEmpty() || text1.isBlank()) {
            throw new IllegalArgumentException("Text is blank or empty");
        }
        char[] chars1 = text1.toLowerCase().toCharArray();
        char[] chars2 = text1.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {

        System.out.println("Podaj pierwszy napis");
        String user1 = userText();
        System.out.println("Podaj drugi napis");
        String user2 = userText();

        boolean result = stringEquals(user1,user2);

        if (result) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }
}
