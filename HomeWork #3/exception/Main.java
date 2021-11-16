package crochomework.exception;

/**
 * HomeWork #3
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Main {

    public static void main(String[] args) {
        //Тест клетки
        try {
            Cage cage1 = new Cage(0, 0);
            //Переопределённый метод toString
            System.out.println("cage1 = " + cage1);
            //Недопустимые координаты клетки
            Cage cage2 = new Cage(66, 99);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }

        //Тест движения пешки
        Cage cageForPawn = new Cage(1, 1);
        Pawn pawn1 = new Pawn("Пешка", cageForPawn, false);
        try {
            pawn1.makeMove(1, 2);
            //Пешка не может ходить назад
            pawn1.makeMove(1, 1);
        } catch (
                IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
        try {
            pawn1.setCage(new Cage(1, 1));
            //Так как пешка стоит в исходной позиции, то она может сделать ход на 2 клетки вперёд
            pawn1.makeMove(1, 3);
            pawn1.makeMove(1, 4);
            //Пешка не может сходить две клетки вперёд
            pawn1.makeMove(1, 6);
        } catch (
                IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
