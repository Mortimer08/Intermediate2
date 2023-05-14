package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ToyStorage {
    //    private int storageId;
    private Comparator comparator;
    private Map<String, Toy> toys;
    private ArrayList<Toy> toysList;

    public ToyStorage() {
        toys = new HashMap<String, Toy>();
        toysList = new ArrayList<>();
        comparator = new ToyChanceComparator();
    }

    public void addToy(Toy toy) {
        if (toys.values().contains(toy)) {
            toy.setQuantity(toy.getQuantity() + 1);
        }
        toys.put(toy.getId(), toy);
        toysList.add(toy);
    }

    public void putToy(Toy toy) {

    }

    public Toy getToy(String id) {
//        toys.
        return toys.get(id);
    }

    public Toy pullToy(Toy toy) {
        toy.setQuantity(toy.getQuantity() - 1);
        return toys.get(toy.getId());
    }

    public void sortByChance() {
        toysList.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder storageString = new StringBuilder();
        for (Toy toy: this.toysList) {
            storageString.append(toy.toString());
        }
        return storageString.toString();
    }
//    public int getQuantity(Toy toy){
//        int quantity;
//        quantity = 1;
//        return quantity;
//    }
}
