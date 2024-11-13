package com.bjni.model;


public class Fruit {
    private String name;
    private double pricePerKg;

    public Fruit(String name, double pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}
