package com.client.paris;

public class ClientProfessionnel extends Client {
    private String raisonSociale;
    private String tvaIntra;
    private String siren;
    private double chiffreAffaire;

    public ClientProfessionnel(String id, String raisonSociale, String tvaIntra, String siren, double chiffreAffaire) {
        super(id);
        this.raisonSociale = raisonSociale;
        this.tvaIntra = tvaIntra;
        this.siren = siren;
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public double getUnitPrice(ProductType type) {
        boolean grosClient = chiffreAffaire >= 10_000_000;
        return switch (type) {
            case TEL_HAUT_DE_GAMME -> grosClient ? 1000 : 1150;
            case TEL_MOYENNE_GAMME -> grosClient ? 550 : 600;
            case LAPTOP -> grosClient ? 900 : 1000;
        };
    }
}
