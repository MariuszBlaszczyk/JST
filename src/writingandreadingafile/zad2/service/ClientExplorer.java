package writingandreadingafile.zad2.service;

import writingandreadingafile.zad2.logic.Client;

import java.math.BigDecimal;
import java.util.Scanner;

public class ClientExplorer {

    public static void printMostValuableClient(Client[] clients) {
        Client mostValuableValue = clients[0];
        for (Client client : clients) {
            if (client.getValue().compareTo(mostValuableValue.getValue()) > 0) {
                mostValuableValue = client;
            }
        }
        System.out.println("The most valuable customer is: " + mostValuableValue);
    }

    public static String readCountryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name the country from which your customers are interested?");
        return scanner.nextLine();
    }

    public static void printClientsFromCountry(Client[] clients, String country) {
        if (clients.length == 0 || clients == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (country.isEmpty() || country.isBlank()) {
            throw new IllegalArgumentException("Country is incorrect");
        }
        System.out.println("Domestic customers: " + country);
        boolean atLeastOneClient = false;
        for (Client client : clients) {
            if (country.equals(client.getCountry())) {
                System.out.println(client);
                atLeastOneClient = true;
            }
        }
        if (!atLeastOneClient) {
            System.out.println("No customers");
        }
    }

    public static void printAvgValueFromCountry(Client[] clients, String country) {
        if (clients.length == 0 || clients == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (country.isEmpty() || country.isBlank()) {
            throw new IllegalArgumentException("Country is incorrect");
        }
        BigDecimal totalValue = new BigDecimal("0");
        int clientsFromCountryCounter = 0;
        for (Client client : clients) {
            if (country.equals(client.getCountry())) {
                totalValue.add(client.getValue());
                clientsFromCountryCounter++;
            }
        }
        if (totalValue.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal avg = totalValue.divide(new BigDecimal(clientsFromCountryCounter));
            System.out.println("Average customer value %s from is " + avg + country);
        }
    }

}
