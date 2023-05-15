package org.example;

import org.example.Lottery.Lottery;
import org.example.Lottery.PrizesQueue;
import org.example.Toys.Toy;
import org.example.Toys.ToyBox;
import org.example.Toys.ToyStorage;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Toy a = new Toy("Car", 20);
        Toy b = new Toy("Constructor", 60);
        Toy c = new Toy("Puppet", 30);
        Toy d = new Toy("Ball", 10);
        ToyStorage ts = new ToyStorage();

        ts.addToy(a, 1000);
        ts.addToy(b, 1000);
        ts.addToy(c, 1000);
        ts.addToy(d, 1000);
        Lottery l = new Lottery(ts);
        PrizesQueue pq = new PrizesQueue();
        HashMap<String, Integer> results = new HashMap<>();
        for (ToyBox tb : ts) {
            results.put(tb.getToy().getName(), tb.getQuantity());
        }
        for (int i = 0; i < 1000; i++) {

            Toy prize = l.selectPrize();
            pq.addPrize(prize);
//            pq.givePrize();
        }
        for (ToyBox tb : ts) {
            Integer previos = results.get(tb.getToy().getName());
            results.put(tb.getToy().getName(), previos - tb.getQuantity());
        }
        System.out.println(results);
    }
}