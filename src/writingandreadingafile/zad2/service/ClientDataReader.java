package writingandreadingafile.zad2.service;

import writingandreadingafile.zad2.logic.Client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ClientDataReader {

    public Client[] readFromFile(String filename) {
        if (filename.isEmpty() || filename.isBlank()) {
            throw new IllegalArgumentException("Incorrect path to file");
        }
        final int lineNumber = countLinesWithoutHeader(filename);
        Client[] clients = new Client[lineNumber];
        try (
                FileReader reader = new FileReader(filename);
                Scanner scan = new Scanner(reader)) {
            scan.nextLine();
            for (int i = 0; i < clients.length; i++) {
                String csvLine = scan.nextLine();
                clients[i] = createClientFromFile(csvLine);
            }
            return clients;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private Client createClientFromFile(String csvLine) {
        if (csvLine.isBlank() || csvLine.isEmpty()) {
            throw new IllegalArgumentException("Line is blank or empty");
        }
        String[] data = csvLine.split(",");
        int id = Integer.parseInt(data[0]);
        String firstName = data[1];
        String lastName = data[2];
        String country = data[3];
        BigDecimal value = new BigDecimal(data[4]);
        return new Client(id, firstName, lastName, country, value);
    }

    private int countLinesWithoutHeader(String filename) {
        int lines = 0;
        try (
                FileReader reader = new FileReader(filename);
                Scanner scan = new Scanner(reader)) {
            scan.nextLine();
            while (scan.hasNextLine()) {
                scan.nextLine();
                lines++;
            }
            return lines;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
