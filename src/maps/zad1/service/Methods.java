package maps.zad1.service;

import maps.zad1.logic.Options;

import java.util.Scanner;

public class Methods {

    private static Scanner scanner = new Scanner(System.in);

    public static void printOptions() {
        System.out.println("Dostępne opcje");
        System.out.println("EXIT - " + Options.EXIT.getValue());
        System.out.println("ADD EMPLOYEE - " + Options.ADD_EMPLOYEE.getValue());
        System.out.println("FIND EMPLOYEE - " + Options.FIND_EMPLOYEE.getValue());
    }

    public static int getStringFromUser() {
        String user = "";
        String regex = "\\d";
        do {
            System.out.println("Give a number");
            user = scanner.nextLine();
        } while (!user.matches(regex));
        return Integer.parseInt(user);
    }

}
