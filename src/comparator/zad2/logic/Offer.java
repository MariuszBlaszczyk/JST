package comparator.zad2.logic;


import java.util.Objects;

public class Offer implements Comparable<Offer> {

    private String city;
    private double price;
    private double area;

    public Offer(String city, double price, double area) {
        this.city = city;
        this.price = price;
        this.area = area;
    }


    public double getPricePerSqm() {
        return price / area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0 && Double.compare(offer.area, area) == 0 && Objects.equals(city, offer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, price, area);
    }

    @Override
    public String toString() {
        return city + ", " + price + "zł, " + area + "mkw, "
                + String.format("%.2f", getPricePerSqm()) + "zł/mkw";
    }

    @Override
    public int compareTo(Offer o) {
        return Double.compare(getPricePerSqm(), o.getPricePerSqm());
    }

}
