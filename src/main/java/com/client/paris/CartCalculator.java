package com.client.paris;

import java.util.List;

public class CartCalculator {
    public static double calculateTotal(Client client, List<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += client.getUnitPrice(p.type()) * p.quantity();
        }
        return total;
    }
}
