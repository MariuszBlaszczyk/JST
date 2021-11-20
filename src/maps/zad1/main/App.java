package maps.zad1.main;

import maps.zad1.logic.Company;
import maps.zad1.logic.Employee;
import maps.zad1.logic.Options;
import maps.zad1.service.Methods;

public class App {

    public static void main(String[] args) {

        Company company = new Company();
        int userOption;

        do {
            Methods.printOptions();
            userOption = Methods.getStringFromUser();
            Options opt = Options.getOptionsFromUser(userOption);
            switch (opt) {
                case ADD_EMPLOYEE -> {
                    Employee employee = company.readAndCreateEmployee();
                    company.addEmployee(employee);
                }
                case FIND_EMPLOYEE -> {
                    company.findEmployee(company);
                }
                case EXIT -> {
                    System.out.println("Papa!!");
                }
                default -> throw new IllegalArgumentException("No Option!");
            }
        } while (userOption != Options.EXIT.getValue());
    }
}
