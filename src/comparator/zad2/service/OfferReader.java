package comparator.zad2.service;


import comparator.zad2.logic.Offer;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class OfferReader {

    public static  Offer[] readOffers(String filename) {
        if (filename.isBlank() || filename.isEmpty()) {
            throw new IllegalArgumentException("Incorrect path to file");
        }
        int arraySize = readLinesWithoutHeader(filename);
        Offer[] offers = new Offer[arraySize];
        try (
                FileReader reader = new FileReader(filename);
                Scanner scan = new Scanner(reader)) {
            scan.nextLine();
            for (int i = 0; i < offers.length; i++) {
                String csvLine = scan.nextLine();
                offers[i] = createOfferFromFile(csvLine);
            }
            return offers;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private static Offer createOfferFromFile(String csvLine) {
        if (csvLine.isBlank() || csvLine.isEmpty()) {
            throw new IllegalArgumentException("Line is blank or empty");
        }
        String[] data = csvLine.split(";");
        return new Offer(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    private static int readLinesWithoutHeader(String filename) {
        int lines = 0;
        try (
                FileReader reader = new FileReader(filename);
                Scanner scanner = new Scanner(reader);
        ) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
            return lines;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
