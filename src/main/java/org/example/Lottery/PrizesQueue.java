package org.example.Lottery;

import org.example.Toys.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;


public class PrizesQueue {
    private ArrayDeque<Toy> prisesQueue;
    private FileWriter fw;

    public PrizesQueue() throws IOException {
        prisesQueue = new ArrayDeque<>();
        fw = new FileWriter("prizes.txt", true);
    }

    public void addPrize(Toy toy) {
        prisesQueue.addLast(toy);
    }

    public void givePrize() throws IOException {
        fw.write(String.valueOf(prisesQueue.getFirst()));
        fw.flush();
    }
}
