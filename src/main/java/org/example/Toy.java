package org.example;
import java.util.UUID;
public class Toy {

    private String id;
    private String name;
    private int quantity;
    private int chance;
    public Toy(String name, int quantity){
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.quantity = quantity;
        this.setChance(50);
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setChance(int chance){
        this.chance = chance;
    }

    private void setId(String id){
        this.id = id;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public int getChance(){
            return this.chance;
    }
    public String getId(){
        return this.id;
    }
}
