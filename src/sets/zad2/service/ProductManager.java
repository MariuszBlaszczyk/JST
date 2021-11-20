package sets.zad2.service;

import sets.zad2.logic.EvaluatedOption;
import sets.zad2.logic.Product;
import sets.zad2.logic.UserChoose;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private Scanner scan = new Scanner(System.in);

    public void mainLoop() {
        int userOption = 0;
        do {
            printOption();
            userOption = readOption();
            evaluatedOption(userOption);
        } while (userOption != UserChoose.EXIT.getValue());
    }

    private void evaluatedOption(int option) {
        if (option == UserChoose.ADD_PRODUCT.getValue()) {
            addNNextProduct();
        } else if (option == UserChoose.EXIT.getValue()) {
            printProducts();
        } else {
            System.out.println("Nieznana opcja");
        }
    }

    private void printProducts() {
        System.out.println("Wszystkie produkty");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void printOption() {
        System.out.println("Dostępne opcje:");
        System.out.println(" > Dodaj nowy produkt - " + UserChoose.ADD_PRODUCT.getValue());
        System.out.println(" > Koniec programu - " + UserChoose.EXIT.getValue());
    }

    private int readOption() {
        System.out.println("Wybierz opcję:");
        int option = scan.nextInt();
        scan.nextLine();
        return option;
    }

    private void addNNextProduct() {
        Product product = createProduct();
        if (products.contains(product)) {
            askAndReplaceProduct(product);
        } else {
            addProduct(product);
        }
    }

    private void askAndReplaceProduct(Product product) {
        System.out.println("Znaleziono produkt o takiej nazwie, wybierz co chcesz zrobić");
        System.out.println("> Zignoruj produkt - " + EvaluatedOption.DISCARD_PRODUCT.getValue());
        System.out.println("> Zamień produkt - " + EvaluatedOption.REPLACE_PRODUCT.getValue());

        int readOption = readOption();
        if (readOption == EvaluatedOption.DISCARD_PRODUCT.getValue()) {
            products.remove(product);
            products.add(product);
        } else {
            System.out.println("W bazie pozostawiono poprzedni produkt");
        }
    }

    private void addProduct(Product product) {
        products.add(product);
        System.out.println("Produkt dodany do bazy");
    }


    private Product createProduct() {
        System.out.println("Podaj nazwę produktu:");
        String name = scan.nextLine();
        System.out.println("Podaj cenę produktu:");
        BigDecimal price = scan.nextBigDecimal();
        scan.nextLine();
        return new Product(name, price);
    }
}
