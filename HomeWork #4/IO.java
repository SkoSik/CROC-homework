package crochomework;

import java.io.*;
import java.util.*;

/**
 * HomeWork #4
 *
 * @author IlyaSlobodyan (SKoSik)
 */

public class IO {

    /**
     * Программа для подсчёта количества слов в тексте
     * В качестве аргумента запуска принимает путь до файла
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Не задан путь к файлу в команде запуска");
        }

        try {
            File text = new File(args[0]);
            Scanner fin = new Scanner(text);
            int counter = 0;
            /*
              Читаем построчно
              Приводим все символы к нижнему регистру для удобства проверки принадлежности символов строки русскому и английскому алфавиту
              Делим строку, используя split
             */
            while (fin.hasNextLine()) {
                String line = fin.nextLine().toLowerCase();
                String[] words = line.split(" ");
                for (String word : words) {
                    /*
                     Считаем, что если первый символ подстроки относится к русскому/английскому алфавиту, то подстрока является словом
                     Без данной проверки программа может посчитать некоторые знаки препинания (Например, тире) за целое слово
                     */
                    if(word.lenght>0) {
                        char s = word.charAt(0);
                        if ((s >= 'a' && s <= 'z') || (s >= 'а' && s <= 'я')) {
                           counter++;
                        }
                    }
                }
            }
            //Выводим ответ в файл out.txt
            PrintWriter fout = new PrintWriter("out.txt");
            fout.println(counter);
            fout.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
