package org.example.Lottery;

import org.example.Toy;
import org.example.ToyStorage;

import java.util.Random;

public class Lottery {
    ToyStorage toyStorage;
    int prizesCounter;

    public Lottery(ToyStorage toyStorage) {
        this.toyStorage = toyStorage;
        this.prizesCounter = 0;
    }

    public Toy selectPrize() {
        if (toyStorage.isEmpty()) {
            return null;
        }
        this.toyStorage.sortByChance();
        Integer chancesSum = 0;
        for (Toy toy : this.toyStorage) {
            chancesSum += toy.getChance();
        }
        Random rnd = new Random();
        Integer choice = rnd.nextInt(1, chancesSum);
//        System.out.println(String.format("choice = %d",choice));
        Integer choncesCount = 0;
        for (Toy toy : this.toyStorage) {
            choncesCount += toy.getChance();
            if (choice <= choncesCount) {
//                Toy prize = new Toy()
                return toyStorage.pullToy(toy);
            }
        }
        return toyStorage.pullLastToy();
    }
}
