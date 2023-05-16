package org.example.Toys;
/**
 * Class ToyBox
 * {@code @autor} Ilya Makarov
 */
public class ToyBox {
    /** Поле количество*/
    private int quantity;
    /** Поле Toy хранящийся в ToyBox*/
    private Toy toy;
    /**
     * Конструктор по умолчанию
     */
    public ToyBox() {

    }
    /**
     * Конструктор с параметрами
     * @param toy - Toy который помещают в ToyBox
     */
    public ToyBox(Toy toy) {
        this.toy = toy;
    }
    /**
     * Конструктор с параметрами
     * @param toy - Toy который помещают в ToyBox
     * @param quantity - количество Toy в ToyBox
     */
    public ToyBox(Toy toy, int quantity) {
        this.toy = toy;
        this.addToys(quantity);
    }
    /**
     * Метод добавления Toy в ToyBox - увеличивает quantity на один
     */
    public void addToy() {
        this.quantity++;
    }
    /**
     * Метод добавления нескольких (одинаковых)
     * Toy в ToyBox - увеличивает quantity на количество decQuantity
     * @param decQuantity - количесто Toy, добавляемых в ToyBox
     */
    public void addToys(int decQuantity) {
        this.quantity += decQuantity;
    }
    /**
     * Метод получения значения поля {@link ToyBox#toy}
     *
     * @return значение поля toy
     */
    public Toy getToy() {
        return this.toy;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
    /**
     * Метод получения значения поля {@link ToyBox#quantity}
     *
     * @return значение поля quantity
     */
    public int getQuantity() {
        return quantity;
    }

//    public void incQuantity() {
//        this.quantity++;
//    }
    /**
     * Метод уменьшения значения поля quantity на один
     *
     * @return true если quantity равно нулю
     */
    public boolean decQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
        return quantity == 0;
    }
}
