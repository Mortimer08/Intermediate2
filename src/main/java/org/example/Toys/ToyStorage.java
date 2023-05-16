package org.example.Toys;

import java.util.*;
/**
 * Class ToyStorage
 * {@code @autor} Ilya Makarov
 */
public class ToyStorage implements Iterable<ToyBox> {
    /** Поле comparator*/
    private Comparator comparator;
    /** Поле списка ToyBox хранящихся в ToyStorage*/
    private ArrayList<ToyBox> toyBoxes;
    /**
     * Конструктор по умолчанию
     */
    public ToyStorage() {
        comparator = new ToyBoxChanceComparator();
        toyBoxes = new ArrayList<>();
    }
    /**
     * Метод добавления Toy в ToyStorage - добавляет Toy в ToyBox
     * с аналогичными Toy или создаёт новый ToyBox, если в ToyStorage
     * нет ToyBox с аналогичными Toy
     * @param toy - игрушка, передаваемая на хранение
     */
    public void addToy(Toy toy) {
        if (toyBoxes.isEmpty()) {
            toyBoxes.add(new ToyBox(toy));
        }
        for (ToyBox toyBox : toyBoxes) {
            if (toyBox.getToy().equals(toy)) {
                toyBox.addToy();
                break;
            }
        }
    }
    /**
     * Метод добавления Toy в ToyStorage - добавляет Toy в колчиестве quantity
     * в ToyBox с аналогичными Toy или создаёт новый ToyBox,
     * если в ToyStorage нет ToyBox с аналогичными Toy
     * @param toy - игрушка, передаваемая на хранение
     * @param quantity - количество Toy передаваемых на хранение
     */
    public void addToy(Toy toy, int quantity) {
//        System.out.println("Toy Adding");
        if (toyBoxes.isEmpty()) {
            toyBoxes.add(new ToyBox(toy, quantity));
//            System.out.println("first box added");
        } else {
            for (ToyBox toyBox : this) {
//                System.out.println(String.format("Toy in Box: %n%s", toyBox.getToy()));
//                System.out.println(String.format("Toy to add: %n%s",  toy));
                if (toyBox.getToy().equals(toy)) {
//                    System.out.println("Совпадение");
                    toyBox.addToys(quantity);
                    break;
                }

            }
            this.toyBoxes.add(new ToyBox(toy, quantity));
//            System.out.println("New Box added");
        }


    }

    /**
     * Метод получения Toy из ToyStorage - извлекает Toy
     * из ToyBox с аналогичными Toy,
     * если из ToyBox извлечена последняя игрушка,
     * ToyBox удаляется из ToyStorage
     * @param toy - игрушка, извлекаемая из ToyStorage
     * @return Toy
     */
    public Toy pullToy(Toy toy) {
        for (ToyBox toyBox : this) {
            if (toyBox.getToy().equals(toy)) {
                if (toyBox.decQuantity()) {
                    this.toyBoxes.remove(toyBox);
                };
                return toy;
            }
        }
        return null;
    }
    /**
     * Метод получения Toy из последнего ToyBox в ToyStorage
     * извлекает Toy из ToyBox с игрушками с наименьшим шансом быть выигранными в лотерею
     * @return Toy
     */
    public Toy pullLastToy() {
        toyBoxes.sort(this.comparator);
        Toy lastToy = toyBoxes.get(toyBoxes.size() - 1).getToy();
        this.pullToy(lastToy);
        return lastToy;
    }
    /**
     * Метод сортировки ToyBox в по убыванию шанса игрушки, хранящейся в ToyBox
     * быть выигранными в лотерею
     */
    public void sortByChance() {
        toyBoxes.sort(comparator);
    }

//    private void deleteIfZeroQuantity(Toy toy) {
//        if (toy.getQuantity() == 0) {
//            toysList.remove(toy);
//        }
//    }
    /**
     * Метод проверки наполнения ToyStorage
     * Возавращает true если в ToyStorage нет ни одного ToyBox
     */
    public boolean isEmpty() {
        return toyBoxes.isEmpty();
    }
    /**
     * Прегрузка метод получения строкового отображения обекта ToyStorage
     */
    @Override
    public String toString() {
        StringBuilder storageString = new StringBuilder();
        for (ToyBox toyBox : this.toyBoxes) {
            storageString.append(toyBox.getToy().toString());
            storageString.append(String.format("Quantity: %d%n", toyBox.getQuantity()));
        }

        return storageString.toString();
    }
    class ToyStorageIterator implements Iterator<ToyBox> {
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex < toyBoxes.size();
        }

        @Override
        public ToyBox next() {
            return toyBoxes.get(iteratorIndex++);
        }
    }

    @Override
    public Iterator<ToyBox> iterator() {
        return new ToyStorageIterator();
    }
}
