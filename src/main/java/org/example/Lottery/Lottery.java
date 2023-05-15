package org.example.Lottery;

import org.example.Toys.Toy;
import org.example.Toys.ToyBox;
import org.example.Toys.ToyStorage;

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
        for (ToyBox toyBox : this.toyStorage) {
            chancesSum += toyBox.getToy().getChance();
        }
        Random rnd = new Random();
        Integer choice = rnd.nextInt(1, chancesSum);
//        System.out.println(String.format("choice = %d",choice));
        Integer choncesCount = 0;
        for (ToyBox toyBox : this.toyStorage) {
            choncesCount += toyBox.getToy().getChance();
            if (choice <= choncesCount) {
//                Toy prize = new Toy()
                return toyStorage.pullToy(toyBox.getToy());
            }
        }
        return toyStorage.pullLastToy();
    }
}
