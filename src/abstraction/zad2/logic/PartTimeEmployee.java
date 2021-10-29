package abstraction.zad2.logic;

import java.math.BigDecimal;
import java.util.Objects;

public class PartTimeEmployee extends Employee {

    private int hours;
    private double hourlyWage;

    public PartTimeEmployee(String firstName, String lastName, int hours, double hourlyWage) {
        super(firstName, lastName);
        this.hours = hours;
        this.hourlyWage = hourlyWage;
    }


    @Override
    public BigDecimal getMonthlySalary() {

        return new BigDecimal(hours * hourlyWage);
    }

    @Override
    public BigDecimal getYearlySalary() {
        return getMonthlySalary().multiply(new BigDecimal(NO_OF_MONTHS));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartTimeEmployee that = (PartTimeEmployee) o;
        return hours == that.hours && Double.compare(that.hourlyWage, hourlyWage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hours, hourlyWage);
    }

}
