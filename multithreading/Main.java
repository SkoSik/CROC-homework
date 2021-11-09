package crochomework.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * HoneWork #5
 *
 * @author Slobodyan Ilya (SkoSik)
 */
public class Main {

    static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";
    static final String TEMPLATE = " ";
    static int sum = 0;

    /**
     * Класс MyCallable реализует интерфейс Callable и является прототипом потока решения задачи
     */
    static class MyCallable implements Callable<Integer> {
        private static final Object lock = new Object();
        int i;

        /**
         * Конструктор MyCallable
         *
         * @param i - индекс символа в строке
         */
        MyCallable(int i) {
            this.i = i;
        }

        public Integer call() {
            if (Matcher.match(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE)) {
                synchronized (lock) {
                    //Суммирую здесь, чтобы продемонстрировать вариант с синхронизацией
                    sum++;
                }
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long current = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<MyCallable> tasks = new ArrayList<>();
        //Создаю лист задач из количества потоков, равных количеству символов в строке, чтобы добиться максимально возможной скорости выполнения
        for (int i = 0; i < INPUT_STRING.length(); i++) {
            tasks.add(new MyCallable(i));
        }
        //Можно получить результат выполнения всех задач в ArrayList<Future<Integer>> и суммировать все его элементы
        pool.invokeAll(tasks);
        pool.shutdown();
        System.out.println("Count of space: " + sum);
        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
