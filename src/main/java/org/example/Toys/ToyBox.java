package org.example.Toys;

public class ToyBox {
    private int quantity;
    private Toy toy;

    public ToyBox() {

    }

    public ToyBox(Toy toy, int quantity) {
        this.addToys(toy, quantity);
    }

    public void addToy(Toy toy) {
        this.quantity++;
    }

    public void addToys(Toy toy, int quantity) {
        this.quantity += quantity;
    }

    public Toy getToy() {
        return this.toy;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQuantity() {
        this.quantity++;
    }

    public boolean decQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
        return quantity == 0;
    }
}
