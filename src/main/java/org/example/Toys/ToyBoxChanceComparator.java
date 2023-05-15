package org.example.Toys;

import java.util.Comparator;

public class ToyBoxChanceComparator implements Comparator<ToyBox> {
    @Override
    public int compare(ToyBox o1, ToyBox o2) {
        if (o1.getToy().getChance() > o2.getToy().getChance())
            return -1;
        else if (o1.getToy().getChance() < o2.getToy().getChance())
            return 1;
        else return 0;
    }
}
