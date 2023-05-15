package org.example.Toys;

public class Toy {

    private String id;
    private String name;
    private int chance;

    public Toy(String name) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.setChance(50);
    }

    public Toy(String name, int chance) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.setChance(chance);
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getChance() {
        return this.chance;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder toyString = new StringBuilder();
        toyString.append(String.format("Toy ID: %s%n", this.id));
        toyString.append(String.format("Toy name: %s%n", this.name));
        toyString.append(String.format("Toy chance: %d%n", this.chance));
        return toyString.toString();
    }
}
