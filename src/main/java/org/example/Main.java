package org.example;

import org.example.Lottery.Lottery;
import org.example.Lottery.PrizesQueue;
import org.example.Toys.Toy;
import org.example.Toys.ToyStorage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Toy a = new Toy("Car", 200);
        Toy b = new Toy("Constructor", 55);
        Toy c = new Toy("Puppet", 50);
        Toy d = new Toy("Ball", 50);
        a.setChance(50);
        b.setChance(20);
        c.setChance(10);
        d.setChance(30);
        ToyStorage ts = new ToyStorage();
        ts.addToy(a);
        ts.addToy(b);
        ts.addToy(c);
        ts.addToy(d);


//        Integer wins[] = {0, 0, 0, 0};
        Lottery l = new Lottery(ts);
        PrizesQueue pq = new PrizesQueue ();
        for (int i = 0; i < 10; i++) {
            Toy prize = l.selectPrize();
            pq.addPrize(prize);
            pq.givePrize();
        }


//        System.out.println(String.format("%d %d %d %d", wins[0], wins[1], wins[2], wins[3]));
    }
}