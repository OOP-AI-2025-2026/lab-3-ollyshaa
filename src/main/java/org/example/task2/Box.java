package org.example.task2;

public class Box {
    private int id;
    private String name;
    private double price;

    public Box(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Box{id=" + this.id + ", name='" + this.name + "', price=" + this.price + "}";
    }
}
