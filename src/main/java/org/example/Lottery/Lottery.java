package org.example.Lottery;

import org.example.Toys.Toy;
import org.example.Toys.ToyBox;
import org.example.Toys.ToyStorage;

import java.util.Random;
/**
 * Class Lottery
 * {@code @autor} Ilya Makarov
 */
public class Lottery {
    /**
     * Поле ToyStorage
     */
    ToyStorage toyStorage;
    /**
     * Поле prizesCounter
     */
    int prizesCounter;
    /**
     * Конструктор с одним параметром
     *
     * @param toyStorage - ToyStorage, из которого будут выбипаться призы
     */
    public Lottery(ToyStorage toyStorage) {
        this.toyStorage = toyStorage;
        this.prizesCounter = 0;
    }
    /**
     * Метод выбора приза
     * @return Toy выбранноу из toyStorage по алгоритму случайного выбора
     * с учётом "веса" выбора
     */
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
                return toyStorage.pullToy(toyBox.getToy());
            }
        }
        return toyStorage.pullLastToy();
    }
}
