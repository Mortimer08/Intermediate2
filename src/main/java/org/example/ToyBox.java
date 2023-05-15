package org.example;

public class ToyBox {
    private int quantity;
    private Toy toy;
    public ToyBox(){

    }
    public void addToy(Toy toy){
        this.quantity ++;
    }
    public void addToys(Toy toy, int quantity){
        this.quantity +=quantity;
    }
}
