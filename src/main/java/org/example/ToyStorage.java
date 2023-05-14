package org.example;

import java.util.*;
import java.util.function.Consumer;

public class ToyStorage implements Iterable<Toy> {
    //    private int storageId;
    private Comparator comparator;
//    private Map<String, Toy> toys;
    private ArrayList<Toy> toysList;
    private int iteratorIndex;

    public ToyStorage() {
//        toys = new HashMap<String, Toy>();
        toysList = new ArrayList<>();
        comparator = new ToyChanceComparator();
        iteratorIndex = 0;
    }

    public void addToy(Toy toy) {
//        if (toys.values().contains(toy)) {
//            toy.setQuantity(toy.getQuantity() + 1);
//        }
//        toys.put(toy.getId(), toy);
        toysList.add(toy);
    }

//    public void putToy(Toy toy) {
//
//    }

//    public Toy getToy(String id) {
////        toys.
//        return toys.get(id);
//    }

    public Toy pullToy(Toy toy) {
        toy.setQuantity(toy.getQuantity() - 1);
        return toy;
    }
    public Toy pullLastToy() {
        toysList.sort(this.comparator);
        Toy lastToy =toysList.get(toysList.size()-1);
        lastToy.setQuantity(lastToy.getQuantity()-1);
        return lastToy;
    }
    public void sortByChance() {
        toysList.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder storageString = new StringBuilder();
        for (Toy toy : this.toysList) {
            storageString.append(toy.toString());
        }
        return storageString.toString();
    }

    class ToyStorageIterator implements Iterator<Toy> {
        @Override
        public boolean hasNext() {
            return iteratorIndex != toysList.size();
        }

        @Override
        public Toy next() {
            return toysList.get(iteratorIndex++);
        }
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyStorageIterator();
    }
//    public int getQuantity(Toy toy){
//        int quantity;
//        quantity = 1;
//        return quantity;
//    }
}
