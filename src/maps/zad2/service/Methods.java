package maps.zad2.service;

import com.sun.source.tree.Tree;
import maps.zad2.logic.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Methods {

    public static Map<String, TreeSet<Product>> productMap(String filename) {
        if (filename.isEmpty() || filename.isBlank()) {
            throw new IllegalArgumentException("File is empty or blank");
        }
        Map<String, TreeSet<Product>> productsMap = new HashMap<>();
        try (Scanner scan = new Scanner(new File(filename))) {
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] data = scan.nextLine().split(";");
                String category = data[0];
                BigDecimal price = new BigDecimal(data[2]);
                Product product = new Product(data[1], price);
                insertProductIntoMap(productsMap, category, product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productsMap;
    }

    private static void insertProductIntoMap(Map<String, TreeSet<Product>> productsMap, String category, Product product) {
        if (productsMap.containsKey(category))
            productsMap.get(category).add(product);
        else {
            TreeSet<Product> categorySet = new TreeSet<>();
            categorySet.add(product);
            productsMap.put(category, categorySet);
        }
    }

    public static String readCategoryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę kategorii dla wyświetlenia statystyk:");
        return scanner.nextLine();
    }

    public static void printCategoryStats(Map<String, TreeSet<Product>> productsMap, String category) {
        TreeSet<Product> products = productsMap.get(category);
        if (products == null)
            System.out.println("Brak produktów w danej kategorii");
        else  {
            printAll(products);
            printAvgPrice(products);
            printCheapestAndExpensiveProduct(products);
        }
    }

    public static void printAll(TreeSet<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void printAvgPrice(TreeSet<Product> products) {
        BigDecimal sumPrice = BigDecimal.ZERO;
        for (Product product : products) {
            sumPrice =sumPrice.add(product.getPrice());
        }
        BigDecimal avgPrice = sumPrice.divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);
        System.out.printf("Średnia cena produktów: " + avgPrice + "\n");
    }

    public static void printCheapestAndExpensiveProduct(TreeSet<Product> products) {
        System.out.println("Najtańszy produkt: " + products.first());
        System.out.println("Najdroższy produkt: " + products.last());
    }


//    public static List<String> read(Path path) {
//        try {
//            return Files.readAllLines(path, StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            throw new IllegalStateException("Error");
//        }
//    }
//
//    public static Map<String, Set<Product>> listToMap(List<String> list) {
//        if (list.isEmpty()) {
//            throw new IllegalArgumentException("List is null");
//        }
//        list
//                .stream()
//                .skip(1)
//                .map()
//    }


}
