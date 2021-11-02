package crochomework.exception;

import java.util.Objects;

/**
 * Класс Figure является абстрактным прототипом шахматной фигуры
 * Будем считать, что Чёрные снизу, а Белые сверху
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public abstract class Figure {
    String name;
    Cage cage;
    boolean color;

    /**
     * Конструктор Figure
     *
     * @param name  Имя
     * @param cage  Клетка
     * @param color Цвет фигуры ( false - чёрный, true - белый)
     */
    public Figure(String name, Cage cage, boolean color) {
        this.name = name;
        this.cage = cage;
        this.color = color;
    }

    /**
     * Сделать ход
     *
     * @param cage новая клетка
     */
    public abstract void makeMove(Cage cage);

    /**
     * Сделать ход
     *
     * @param x координата X
     * @param y координата Y
     */
    public abstract void makeMove(int x, int y);

    public String getName() {
        return name;
    }

    public Cage getCage() {
        return cage;
    }

    public String getColor() {
        return this.color ? "Белая" : "Чёрная";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String toString() {
        return name + " в " + cage;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(name, figure.name) && Objects.equals(cage, figure.cage);
    }

    public int hashCode() {
        return Objects.hash(name, cage);
    }
}
