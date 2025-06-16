package com.client.paris;

public class ClientParticulier extends Client {
    private String nom;
    private String prenom;

    public ClientParticulier(String id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public double getUnitPrice(ProductType type) {
        return switch (type) {
            case TEL_HAUT_DE_GAMME -> 1500;
            case TEL_MOYENNE_GAMME -> 800;
            case LAPTOP -> 1200;
        };
    }
}
