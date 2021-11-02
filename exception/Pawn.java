package crochomework.exception;

/**
 * Класс Pawn является наследником Figure и является прототипом шахматной пешки
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Pawn extends Figure {

    /**
     * Конструктор Pawn
     *
     * @param name  Имя
     * @param cage  Клетка
     * @param color Цвет фигуры
     */
    public Pawn(String name, Cage cage, boolean color) {
        super(name, cage, color);
    }

    /**
     * Сделать ход
     *
     * @param cage новая клетка
     */
    public void makeMove(Cage cage) {
        int y1 = this.cage.y;
        int y2 = cage.y;
        boolean flag;
        if (color) {
            flag = (y1 == 6 && y2 + 2 == y1) || (y2 + 1 == y1);
        } else {
            flag = (y1 == 1 && y1 + 2 == y2) || (y1 + 1 == y2);
        }
        if (flag) {
            System.out.printf("Пешка из %s сходила в %s%n", this.cage, cage);
            this.cage = cage;
        } else {
            throw new IllegalArgumentException("Пешка из " + this.cage + " не может сходить в " + cage + "\n");
        }
    }

    /**
     * Сделать ход
     *
     * @param x координата X
     * @param y координата Y
     */
    public void makeMove(int x, int y) {
        makeMove(new Cage(x, y));
    }
}
