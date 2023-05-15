package org.example.Toys;

import java.util.Comparator;

public class ToyChanceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        if (o1.getChance() > o2.getChance())
            return -1;
        else if (o1.getChance() < o2.getChance())
            return 1;
        else return 0;
    }
}
