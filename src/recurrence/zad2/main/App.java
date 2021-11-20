package recurrence.zad2.main;

import recurrence.zad2.logic.Cart;
import recurrence.zad2.logic.Product;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {


        Cart cart = new Cart();
        cart.addProduct(new Product("mleko", new BigDecimal("1")));
        cart.addProduct(new Product("czekolada", new BigDecimal("2")));
        cart.addProduct(new Product("jogurt", new BigDecimal("3")));
        System.out.println(cart.totalCost());
    }
}
