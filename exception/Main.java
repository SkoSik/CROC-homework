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
            System.out.println("cage1 = " + cage1);
            Cage cage2 = new Cage(66, 99);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }

        //Тест движения пешки
        Cage cageForPawn = new Cage(1, 1);
        Pawn pawn1 = new Pawn("Пешка", cageForPawn, false);
        try {
            pawn1.makeMove(1, 2);
            pawn1.makeMove(1, 1);
        } catch (
                IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
        try {
            pawn1.setCage(new Cage(1, 1));
            pawn1.makeMove(1, 3);
            pawn1.makeMove(1, 4);
            pawn1.makeMove(1, 6);
        } catch (
                IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
