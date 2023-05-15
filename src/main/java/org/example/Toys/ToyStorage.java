package org.example.Toys;

import java.util.*;

public class ToyStorage implements Iterable<Toy> {
    private Comparator comparator;
    private ArrayList<ToyBox> toyBoxes;

    public ToyStorage() {
        comparator = new ToyChanceComparator();
    }

    public void addToy(Toy toy) {
        for (ToyBox toyBox: toyBoxes) {
            if (toyBox.getToy().equals(toy)){
                toyBox.incQuantity();
                break;
            }
        }
        toyBoxes.add(new ToyBox(toy,1));
    }
    public void addToy(Toy toy, int quantity) {
        for (ToyBox toyBox: toyBoxes) {
            if (toyBox.getToy().equals(toy)){
                toyBox.setQuantity(quantity);
                break;
            }
        }
        toyBoxes.add(new ToyBox(toy,quantity));
    }


    public Toy pullToy(Toy toy) {
        for (ToyBox toyBox: toyBoxes) {
            if (toyBox.getToy().equals(toy)){
                if(toyBox.decQuantity()){
                    this.toyBoxes.remove(toy);
                };
                return toy;
            }
        }
        return null;
    }

    public Toy pullLastToy() {
        toyBoxes.sort(this.comparator);
        Toy lastToy = toyBoxes.get(toyBoxes.size() - 1).getToy();
        this.pullToy(lastToy);
        return lastToy;
    }

    public void sortByChance() {
        toyBoxes.sort(comparator);
    }

//    private void deleteIfZeroQuantity(Toy toy) {
//        if (toy.getQuantity() == 0) {
//            toysList.remove(toy);
//        }
//    }

    public boolean isEmpty() {
        return toyBoxes.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder storageString = new StringBuilder();
        for (ToyBox toyBox : this.toyBoxes) {
            storageString.append(toyBox.getToy().toString());
        }
        return storageString.toString();
    }

    class ToyStorageIterator implements Iterator<Toy> {
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex != toyBoxes.size();
        }

        @Override
        public Toy next() {
            return toyBoxes.get(iteratorIndex++).getToy();
        }
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyStorageIterator();
    }
}
