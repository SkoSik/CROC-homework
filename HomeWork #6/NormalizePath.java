package crochomework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * HomeWork #6
 *
 * @author IlyaSlobodyan (SKoSik)
 */
public class NormalizePath {

    public static void main(String[] args) {
        //Пример из задания:  КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики
        Scanner in = new Scanner(System.in);
        //Читаем путь и разбиваем его на строки папок
        String[] path = in.nextLine().split("/");
        Deque<String> folders = new ArrayDeque<>();
        /*
         * Проходим по массиву папок пути и заполняем очередь:
         * если встречено "." - игнорируем
         * если встречено ".." - проверяем:
         *                              пуста ли очередь и является ли последний её элемент ".."
         *                              если true, заносим в очередь ".."
         *                              иначе удаляем последний элемент очереди (спускаемся на папку вниз)
         * если встречена любая отличная строка - папка - заносим её в очередь         *
         */
        for (String folder : path) {
            switch (folder) {
                case ".":
                    break;
                case "..":
                    if (folders.isEmpty() || folders.getLast() == "..") {
                        folders.add(folder);
                    } else {
                        folders.remove();
                    }
                    break;
                default:
                    folders.add(folder);
            }
        }
        //Собираем нормализованный путь
        String answer = folders.stream().collect(Collectors.joining("/"));
        System.out.println(answer);
    }
}
