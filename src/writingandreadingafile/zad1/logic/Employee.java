package writingandreadingafile.zad1.logic;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee extends Person {

    private BigDecimal salary;

    public Employee(String firstName, String lastName, BigDecimal salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + salary + " zł";
    }
}
