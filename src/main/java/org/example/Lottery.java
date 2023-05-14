package org.example;

import java.util.Random;

public class Lottery {
    ToyStorage toyStorage;

    public Lottery(ToyStorage toyStorage) {
        this.toyStorage = toyStorage;
    }

    public Toy selectPrize() {
//        System.out.println("Prize_selected");
        toyStorage.sortByChance();
        System.out.println(toyStorage);
        Integer chancesSum = 0;
        for (Toy toy : toyStorage) {
            chancesSum += toy.getChance();
        }
        System.out.println(chancesSum);
        Random rnd = new Random();
        Integer choice = rnd.nextInt(1, 100);
        Integer choncesCount = 0;

        for (Toy toy : toyStorage) {
            choncesCount += toy.getChance();
            if (choice <= choncesCount) {
                return toy;
            }

        }
        return toyStorage.pullLastToy();
    }

}
