package crochomework.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class StartThreads {
    static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";
    static final String TEMPLATE = " ";
    static int sum = 0;

    StartThreads() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<MyCallable> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new MyCallable());
        }
        pool.invokeAny(tasks);
        pool.shutdown();
        System.out.println("Count of space: " + sum);
    }


    public static class MyCallable implements Callable<Integer> {
        private static final Object lock = new Object();

        public Integer call() throws Exception {
            try {
                for(int i=0;i<INPUT_STRING.length();i++){
                    if (i < INPUT_STRING.length() && Matcher.match(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE)) {
                        synchronized (lock){
                            sum++;
                        }
                        System.out.println(i);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return sum;
        }
    }
}