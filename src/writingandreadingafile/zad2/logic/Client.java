package writingandreadingafile.zad2.logic;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private BigDecimal value;

    public Client(int id, String firstName, String lastName, String country, BigDecimal value) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(country, client.country) && Objects.equals(value, client.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country, value);
    }

    @Override
    public String toString() {
        return id + ": " +
                firstName + " " +
                lastName + ", " +
                country + ", " +
                value + "zł";
    }
}
