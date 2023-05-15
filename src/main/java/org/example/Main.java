package org.example;

import org.example.Lottery.Lottery;
import org.example.Lottery.PrizesQueue;
import org.example.Toys.Toy;
import org.example.Toys.ToyBox;
import org.example.Toys.ToyStorage;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Toy a = new Toy("Car", 20);
        Toy b = new Toy("Constructor", 55);
        Toy c = new Toy("Puppet",10);
        Toy d = new Toy("Ball",30);
        ToyStorage ts = new ToyStorage();

        ts.addToy(a,50);
        ts.addToy(b,50);
        ts.addToy(c,50);
        ts.addToy(d,50);
        System.out.println(ts);

        Integer wins[] = {0, 0, 0, 0};
        Lottery l = new Lottery(ts);
        PrizesQueue pq = new PrizesQueue ();
        for (int i = 0; i < 10; i++) {
            Toy prize = l.selectPrize();
            pq.addPrize(prize);
            pq.givePrize();
        }


        System.out.println(String.format("%d %d %d %d", wins[0], wins[1], wins[2], wins[3]));
    }
}