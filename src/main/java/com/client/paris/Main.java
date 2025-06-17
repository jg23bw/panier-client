package com.client.paris;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientParticulier particulier = new ClientParticulier("1", "Dupont", "Jean");
        ClientProfessionnel pro = new ClientProfessionnel("2", "MaBoite", "FR123456789", "123456789", 11_000_000);

        List<Product> panier = List.of(
                new Product(ProductType.TEL_HAUT_DE_GAMME, 1),
                new Product(ProductType.LAPTOP, 2)
        );

        System.out.println("Total particulier : " + CartCalculator.calculateTotal(particulier, panier) + " €");
        System.out.println("Total pro : " + CartCalculator.calculateTotal(pro, panier) + " €");
    }
}
