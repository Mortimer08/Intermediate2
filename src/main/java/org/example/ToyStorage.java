package org.example;

import java.util.*;

public class ToyStorage implements Iterable<Toy> {
    private Comparator comparator;
    private ArrayList<Toy> toysList;
    private ArrayList<ToyBox> toyBoxes;

    public ToyStorage() {
        toysList = new ArrayList<>();
        comparator = new ToyChanceComparator();
    }

    public void addToy(Toy toy) {
        if (toysList.contains(toy)) {
            toy.incQuantity();
        }
        toysList.add(toy);
    }

    public void addToy(Toy toy, int quantity) {
        if (toysList.contains(toy)) {
            toy.setQuantity(toy.getQuantity() + quantity);
        }
        toysList.add(toy);
    }

    public Toy pullToy(Toy toy) {
        if (toy.decQuantity()) {
            this.deleteIfZeroQuantity(toy);
            return toy;
        }
        return null;
    }

    public Toy pullLastToy() {
        toysList.sort(this.comparator);
        Toy lastToy = toysList.get(toysList.size() - 1);
        if (lastToy.decQuantity()) {
            return lastToy;
        }
        this.deleteIfZeroQuantity(lastToy);
        return null;
    }

    public void sortByChance() {
        toysList.sort(comparator);
    }

    private void deleteIfZeroQuantity(Toy toy) {
        if (toy.getQuantity() == 0) {
            toysList.remove(toy);
        }
    }

    public boolean isEmpty() {
        return toysList.isEmpty();
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
        private int iteratorIndex = 0;

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
}
