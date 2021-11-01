package writingandreadingafile.zad1.logic;

import java.io.Serializable;
import java.util.Arrays;

public class Company implements Serializable {

    public static final int NUMBER_OF_EMPLOYEE = 3;
    private Employee[] employees = new Employee[NUMBER_OF_EMPLOYEE];
    private int index = 0;

    public void addEmployee(Employee employee) {
        employees[index] = employee;
        index++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Employee employee : employees) {
            builder.append(employee.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
