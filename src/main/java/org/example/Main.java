package org.example;

public class Main {
    public static void main(String[] args) {
        Toy a = new Toy("Toy1", 2);
        Toy b = new Toy("Toy2", 5);
        a.setChance(30);
        ToyStorage ts = new ToyStorage();
        ts.addToy(a);
        ts.addToy(b);
        ts.pullToy(a);

        System.out.println(a.getQuantity());
        Lottery l = new Lottery(ts);
        l.selectPrize();

    }
}