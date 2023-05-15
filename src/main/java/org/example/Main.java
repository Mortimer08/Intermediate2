package org.example;

import org.example.Lottery.Lottery;
import org.example.Lottery.PrizesQueue;
public class Main {
    public static void main(String[] args) {
        Toy a = new Toy("Car", 200);
        Toy b = new Toy("Constructor", 55);
        Toy c = new Toy("Puppet", 50);
        Toy d = new Toy("Ball", 50);
        a.setChance(10);
        b.setChance(20);
        c.setChance(30);
        d.setChance(30);
        ToyStorage ts = new ToyStorage();
        ts.addToy(a);
        ts.addToy(b);
        ts.addToy(c);
        ts.addToy(d);
//        ts.pullToy(a);


        Integer wins[] = {0, 0, 0, 0};
        Lottery l = new Lottery(ts);
        PrizesQueue pq = new PrizesQueue ();
        for (Integer i = 0; i < 100; i++) {
            Toy prize = l.selectPrize();
            pq.addPrize(prize);
            System.out.println(String.format("Prize: %s",prize));
            if (prize.equals(a)) {
                wins[0] += 1;
            } else if (prize.equals(b)) {
                wins[1] += 1;
            } else if (prize.equals(c)) {
                wins[2] += 1;
            } else if (prize.equals(d)) {
                wins[3] += 1;
            }
        }
        System.out.println(String.format("%d %d %d %d", wins[0], wins[1], wins[2], wins[3]));
    }
}