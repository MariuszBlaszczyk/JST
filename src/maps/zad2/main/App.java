package maps.zad2.main;

import maps.zad2.logic.Product;
import maps.zad2.service.Methods;

import java.util.Map;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {


        Map<String, TreeSet<Product>> productMap = Methods.productMap("src/maps/zad2/media.csv");
        String category = Methods.readCategoryFromUser();
        Methods.printCategoryStats(productMap, category);

    }
}
