package abstraction.zad2.logic;

import java.math.BigDecimal;
import java.util.Objects;

public class FullTimeEmployee extends Employee {

    private BigDecimal baseSalary;
    private static final double YEARLY_BONUS = 0.05;

    public FullTimeEmployee(String firstName, String lastName, BigDecimal baseSalary) {
        super(firstName, lastName);
        this.baseSalary = baseSalary;
    }

    @Override
    public BigDecimal getMonthlySalary() {
        return baseSalary;
    }

    @Override
    public BigDecimal getYearlySalary() {
        BigDecimal yearly = baseSalary.multiply(new BigDecimal(NO_OF_MONTHS));
        BigDecimal bonus = yearly.multiply(new BigDecimal(YEARLY_BONUS));
        return yearly.add(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FullTimeEmployee that = (FullTimeEmployee) o;
        return Objects.equals(baseSalary, that.baseSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }
}
