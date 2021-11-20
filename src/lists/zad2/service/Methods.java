package lists.zad2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {


    private static int numberFromUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static List<Integer> returnList() {
        List<Integer> numbers = new ArrayList<>();
        int userNumber = 0;
        boolean numberIsCorrect = true;
        while (numberIsCorrect) {
            System.out.println("Podaj liczbę większą od zera i podzielną przez 5");
            userNumber = numberFromUser();
            if (userNumber >= 0 && userNumber % 5 == 0) {
                numbers.add(userNumber);
            } else {
                numberIsCorrect = false;
            }
        }
        return numbers;
    }

    private static int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void showStatistic(List<Integer> numbers) {
        int sum = sumNumbers(numbers);
        double avg = sum / numbers.size();

        System.out.println("Ile poprawnych liczb: " + numbers.size());
        System.out.println("Ich suma wynosi: " + sum);
        System.out.println("Natomiast średnia to: " + avg);
    }


}
