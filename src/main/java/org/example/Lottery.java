package org.example;

public class Lottery {
    ToyStorage toyStorage;
    public Lottery(ToyStorage toyStorage){
        this.toyStorage = toyStorage;
    }
    public Toy selectPrize(){
        System.out.println("Prize_selected");

//        toyStorage.
        Toy prize = new Toy("prize_toy", 1);
        return prize;
    }
}
