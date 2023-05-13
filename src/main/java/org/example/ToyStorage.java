package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToyStorage {
    private int storageId;
    private Map<String, Toy> toys;
    public ToyStorage(){
        toys = new HashMap<String,Toy>();
    }

    public void addToy(Toy toy){
        if (toys.values().contains(toy)) {
            toy.setQuantity(toy.getQuantity()+1);
        }
        toys.put(toy.getId(),toy);
    }
    public void putToy(Toy toy){

    }
    public Toy getToy(String id){
//        toys.
        return toys.get(id);
    }

    public Toy pullToy(Toy toy){
        toy.setQuantity(toy.getQuantity()-1);
        return toys.get(toy.getId());
    }

//    public int getQuantity(Toy toy){
//        int quantity;
//        quantity = 1;
//        return quantity;
//    }
}
