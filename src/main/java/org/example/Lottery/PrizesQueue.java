package org.example.Lottery;
import org.example.Toy;
import java.util.Queue;
import
public class PrizesQueue {
    private Queue<Toy> prisesQueue;
    public PrizesQueue(){

    }
    public void addPrize(Toy toy){
        prisesQueue.add(toy);
    }

}
