/**
 * Class Toy
 *
 * @autor Ilya Makarov
 */

package org.example.Toys;

/**
 * Class Toy
 * {@code @autor} Ilya Makarov
 */
public class Toy {
    /**
     * Поле уникльный идентификатор Toy
     */
    private String id;
    /**
     * Поле уникльного имя Toy
     */
    private String name;
    /**
     * Поле шанс выбора Toy в качестве приза
     */
    private int chance;

    /**
     * Конструктор с одним параметром
     *
     * @param name - имя
     */
    public Toy(String name) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.setChance(50);
    }

    /**
     * Конструктор с двумя параметрами
     *
     * @param name   - имя
     * @param chance - шанс выбора Toy в качестве приза
     */
    public Toy(String name, int chance) {
        this.setId(String.valueOf(java.util.UUID.randomUUID()));
        this.name = name;
        this.setChance(chance);
    }

    /**
     * Метод установки шанса выбора Toy в качестве приза
     */
    public void setChance(int chance) {
        this.chance = chance;
    }

    /**
     * Метод установки уникального идентификатора Toy
     * @param id - уникальный идентификатор
     */
    private void setId(String id) {
        this.id = id;
    }
    /**
     * Метод получения значения поля {@link Toy#chance}
     *
     * @return значение поля chance
     */
    public int getChance() {
        return this.chance;
    }

    /**
     * Метод получения значения поля {@link Toy#name}
     *
     * @return значение поля name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Прегрузка метод получения строкового отображения обекта Toy
     */
    @Override
    public String toString() {
        StringBuilder toyString = new StringBuilder();
        toyString.append(String.format("Toy ID: %s%n", this.id));
        toyString.append(String.format("Toy name: %s%n", this.name));
        toyString.append(String.format("Toy chance: %d%n", this.chance));
        return toyString.toString();
    }
}
