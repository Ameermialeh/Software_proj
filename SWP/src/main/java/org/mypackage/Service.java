package org.mypackage;

public class Service {

    int id;
    String name;
    double price;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Service(int id, String name, double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
