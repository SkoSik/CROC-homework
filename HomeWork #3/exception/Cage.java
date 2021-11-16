package crochomework.exception;

import java.util.Objects;

/**
 * Класс Cage является прототипом клетки шахматной доски
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Cage {
    int x;
    int y;

    /**
     * Конструктор Cage
     *
     * @param x координата X
     * @param y координата Y
     */
    public Cage(int x, int y) {
        checkCords(x, 'x');
        checkCords(y, 'y');
        this.x = x;
        this.y = y;
    }

    /**
     * Проверка координаты на валидность
     *
     * @param c значение координаты
     * @param s символ координаты
     * @throws IllegalArgumentException соответсующее исключение
     */
    public void checkCords(int c, char s) throws IllegalArgumentException {
        if (c < 0 || c > 7) {
            throw new IllegalArgumentException("Значение координаты " + s + " не может быть " + c + "\n");
        }
    }

    /**
     * Перевод координаты в необходимый формат
     */
    public String toString() {
        return "" + (char) (x + 97) + (y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        checkCords(x, 'x');
        this.x = x;
    }

    public void setY(int y) {
        checkCords(y, 'y');
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cage cage = (Cage) o;
        return x == cage.x && y == cage.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}
