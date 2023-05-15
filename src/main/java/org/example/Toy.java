package org.example;

public class Toy {

    private String id;
    private String name;
    private int quantity;
    private int chance;

    public Toy(String name) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.quantity = 1;
        this.setChance(50);
    }

    public Toy(String name, int quantity) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.quantity = quantity;
        this.setChance(50);
    }

    public Toy(String name, int quantity, int chance) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.quantity = quantity;
        this.setChance(chance);
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
            return true;
        }
        return false;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getChance() {
        return this.chance;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder toyString = new StringBuilder();
        toyString.append(String.format("Toy ID: %s%n", this.id));
        toyString.append(String.format("Toy name: %s%n", this.name));
        toyString.append(String.format("Toy quantity: %d%n", this.quantity));
        toyString.append(String.format("Toy chance: %d%n", this.chance));
        return toyString.toString();
    }
}
