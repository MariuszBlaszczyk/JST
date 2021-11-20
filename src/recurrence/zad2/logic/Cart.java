package recurrence.zad2.logic;

import java.math.BigDecimal;

public class Cart {

    private static final int MAXIMAL_CART_SIZE = 10;
    private Product[] products = new Product[MAXIMAL_CART_SIZE];
    private int productsCount;

    public void addProduct(Product product) {
        if (productsCount < MAXIMAL_CART_SIZE) {
            products[productsCount] = product;
            productsCount++;
        }
    }

    public BigDecimal totalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (int i = 0; i < productsCount; i++) {
            totalCost = totalCost.add(products[i].getPrice());
        }
        return totalCost;
    }


//    BigDecimal totalCost() {
//        return sumPrices();
//    }
//
//    private BigDecimal sumPrices(BigDecimal counter) {
//        if (productsCount == 0)
//            return BigDecimal.ZERO;
//        else if (counter < (productsCount - 1))
//            return products[counter].getPrice() + sumPrices(++counter);
//        else
//            return products[counter].getPrice();
//    }


}
