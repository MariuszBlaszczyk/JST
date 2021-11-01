package writingandreadingafile.zad1.service;


import writingandreadingafile.zad1.logic.Company;
import writingandreadingafile.zad1.logic.Employee;
import writingandreadingafile.zad1.logic.Read;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class IO {

    private static final String FILE_NAME = "employees.txt";
    private static Scanner scan = new Scanner(System.in);

    public void startMethod() {
        System.out.println("Wprowadzenie danych pracowników - " + Read.FROM_USER.getValue());
        System.out.println("Wczytaj i wyświetl dane z pliku - " + Read.FROM_FILE.getValue());
//        int option = scan.nextInt();
//        if (option == Read.FROM_USER.getValue()) {
//            Company company = createCompany();
//            writeFile(company);
//        } else if (option == Read.FROM_FILE.getValue()) {
//            Company company = null;
//            try {
//                company = readFile();
//        System.out.println(company);
//            } catch (IOException | ClassNotFoundException e) {
//                System.out.println("Data reading error");
//            }
//
//
//
//        } else {
//            throw new IllegalArgumentException("Incorrect value");
//        }

        Read read = chooseOption();
        switch (read) {
            case FROM_USER -> {
                Company company = createCompany();
                writeFile(company);
                System.out.println(company);
            }
            case FROM_FILE -> {
                Company company = null;
                try {
                    company = readFile();
                    System.out.println(company);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Data reading error");
                }

            }
            default -> throw new IllegalStateException("Unexpected value: ");
        }
    }


    private static Read chooseOption() {
        int userChoose = scan.nextInt();
        Read sc = Read.fromValue(userChoose);
        return sc;
    }

    private Company createCompany() {
        Company company = new Company();
        for (int i = 0; i < Company.NUMBER_OF_EMPLOYEE; i++) {
            System.out.println("Please enter a first name");
            String firstName = scan.next();
            System.out.println("Please enter a last name");
            String lastName = scan.next();
            System.out.println("Please enter a salary");
            BigDecimal salary = scan.nextBigDecimal();
            scan.nextLine();
            company.addEmployee(new Employee(firstName, lastName, salary));
        }
        return company;
    }

    private void writeFile(Company company) {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(company);
            System.out.println("Save file");
        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    private static Company readFile() throws IOException, ClassNotFoundException {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Company) ois.readObject();
        }


    }
}
