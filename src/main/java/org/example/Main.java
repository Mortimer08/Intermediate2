package org.example;

public class Main {
    public static void main(String[] args) {
        Toy a = new Toy("Toy1", 2);
        Toy b = new Toy("Toy2", 5);
        Toy c = new Toy("Toy3", 5);
        a.setChance(10);
        b.setChance(10);
        c.setChance(10);
        ToyStorage ts = new ToyStorage();
        ts.addToy(a);
        ts.addToy(b);
        ts.addToy(c);
//        ts.pullToy(a);

//        System.out.println(a.getQuantity());
        Integer wins[] = {0, 0, 0};
        Lottery l = new Lottery(ts);
        l.selectPrize();
        System.out.println(ts);
        for (Integer i = 0; i < 100; i++) {
            Toy prize = l.selectPrize();
//            System.out.println(prize);
            if (prize.equals(a)) {
                wins[0] += 1;
            } else if (prize.equals(b)) {
                wins[1] += 1;
            } else if (prize.equals(c)) {
                wins[2] += 1;
            }
        }

        System.out.println(String.format("%d %d %d",wins[0], wins[1], wins[2]));
//        System.out.println(a);
//        System.out.println(ts);
//        ts.sortByChance();
//        System.out.println(ts);
    }
}