package org.example.Toys;

import java.util.*;

public class ToyStorage implements Iterable<ToyBox> {
    private Comparator comparator;
    private ArrayList<ToyBox> toyBoxes;

    public ToyStorage() {
        comparator = new ToyBoxChanceComparator();
        toyBoxes = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        if (toyBoxes.isEmpty()) {
            toyBoxes.add(new ToyBox(toy));
        }
        for (ToyBox toyBox : toyBoxes) {
            if (toyBox.getToy().equals(toy)) {
                toyBox.addToy();
                break;
            }
        }
    }

    public void addToy(Toy toy, int quantity) {
//        System.out.println("Toy Adding");
        if (toyBoxes.isEmpty()) {
            toyBoxes.add(new ToyBox(toy, quantity));
//            System.out.println("first box added");
        } else {
            for (ToyBox toyBox : this) {
//                System.out.println(String.format("Toy in Box: %n%s", toyBox.getToy()));
//                System.out.println(String.format("Toy to add: %n%s",  toy));
                if (toyBox.getToy().equals(toy)) {
//                    System.out.println("Совпадение");
                    toyBox.addToys(quantity);
                    break;
                }

            }
            this.toyBoxes.add(new ToyBox(toy, quantity));
//            System.out.println("New Box added");
        }


    }


    public Toy pullToy(Toy toy) {
        for (ToyBox toyBox : this) {
            if (toyBox.getToy().equals(toy)) {
                if (toyBox.decQuantity()) {
                    this.toyBoxes.remove(toy);
                }
                ;
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
            storageString.append(String.format("Quantity: %d%n", toyBox.getQuantity()));
        }

        return storageString.toString();
    }

    class ToyStorageIterator implements Iterator<ToyBox> {
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex < toyBoxes.size();
        }

        @Override
        public ToyBox next() {
            return toyBoxes.get(iteratorIndex++);
        }
    }

    @Override
    public Iterator<ToyBox> iterator() {
        return new ToyStorageIterator();
    }
}
