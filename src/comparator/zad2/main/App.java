package comparator.zad2.main;

import comparator.zad2.logic.Offer;
import comparator.zad2.service.OfferReader;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Offer[] offers = OfferReader.readOffers("src/comparator/zad2/flats.csv");
        Arrays.sort(offers);
        for (Offer offer : offers) {
            System.out.println(offer);
        }

    }
}
