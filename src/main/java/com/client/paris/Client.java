package com.client.paris;

public abstract class Client {
    protected String id;

    public Client(String id) {
        this.id = id;
    }

    public abstract double getUnitPrice(ProductType type);
}
