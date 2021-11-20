package maps.zad1.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Company {

    private Map<String, Employee> employeeMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public boolean addEmployee(Employee employee) {
        String key = employee.getFirstName() + " " + employee.getLastName();
        if (employeeMap.containsKey(key)) {
            return false;
        }
        employeeMap.put(key, employee);
        return true;
    }

    public Employee getEmployee(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        return employeeMap.get(key);
    }

    public Employee readAndCreateEmployee() {
        System.out.println("Podaj imię");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = scanner.nextLine();
        System.out.println("Podaj wypłatę");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        return new Employee(firstName, lastName, salary);
    }

    public void findEmployee(Company company) {
        System.out.println("Podaj imię");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = scanner.nextLine();
        Employee employee = company.getEmployee(firstName, lastName);
        if (employee == null)
            System.out.println("Brak takiego pracownika");
        else
            System.out.println(employee);
    }
}
