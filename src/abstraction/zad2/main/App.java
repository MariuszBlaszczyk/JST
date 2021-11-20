package abstraction.zad2.main;

import abstraction.zad2.logic.Employee;
import abstraction.zad2.logic.FullTimeEmployee;
import abstraction.zad2.logic.PartTimeEmployee;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        Employee[] employees = createEmployees();
        BigDecimal totalMonthlySalaries = totalMonthlySalaries(employees);
        BigDecimal totalYearlySalaries = totalYearlySalaries(employees);

        printEmployees(employees);
        System.out.println("Suma miesięcznych wynagrodzeń: " + totalMonthlySalaries);
        System.out.println("Suma rocznych wynagrodzeń: " + totalYearlySalaries);
    }

    private static void printEmployees(Employee[] employees) {
        System.out.println("Pracownicy:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static BigDecimal totalYearlySalaries(Employee[] employees) {
        BigDecimal totalYearlySalaries = new BigDecimal("0");
        for (Employee employee : employees) {
            totalYearlySalaries.add(employee.getYearlySalary());
        }
        return totalYearlySalaries;
    }

    private static BigDecimal totalMonthlySalaries(Employee[] employees) {
        BigDecimal totalMonthlySalaries = new BigDecimal("0");
        BigDecimal result = new BigDecimal("0");
        for (Employee employee : employees) {
            result = totalMonthlySalaries.add(employee.getMonthlySalary());
        }
        return result;
    }

    private static Employee[] createEmployees() {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee("Jan", "Kowalski", new BigDecimal("5000"));
        employees[1] = new PartTimeEmployee("Anna", "Borowska", 10, 80);
        return employees;
    }
}

