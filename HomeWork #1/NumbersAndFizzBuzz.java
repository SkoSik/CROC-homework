package crochomework;

/**
 * HomeWork #1
 *
 * @author Slobodyan Ilya (SkoSik)
 */

public class NumbersAndFizzBuzz {

    /**
     * Проверка кратности
     *
     * @param a делимое
     * @param b возможное кратное
     * @param s вывод при случаи кратности
     * @return 1 или 0 в зависимости от кратности
     */
    public static byte checkMultiplicity(byte a, byte b, String s) {
        if (a % b == 0) {
            System.out.print(s);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        for (byte i = 1; i < 101; i++) {
            //Проверка кратности i на 3 и 5. Если ни одна из проверок не вернёт 1, то выводится i
            if (checkMultiplicity(i, (byte) 3, "Fizz") + checkMultiplicity(i, (byte) 5, "Buzz") == 0) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}