package abstraction.zad2.logic;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Employee {

    public static final int NO_OF_MONTHS = 12;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    abstract public BigDecimal getMonthlySalary();

    abstract public BigDecimal getYearlySalary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName
                + ", wypłata miesięczna: " + getMonthlySalary()
                + ", wypłata roczna: " + getYearlySalary();
    }
}
