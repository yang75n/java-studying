package com.test.concurrent.j_u_concurrent;


import java.util.concurrent.*;

public class TestFutureCallable {

    static class SumTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = 0; i < 9000; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Start:" + System.currentTimeMillis());
        long nanotime = System.nanoTime();

        FutureTask<Long> futureTask = new FutureTask<>(new SumTask());
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(futureTask);
        new Thread(futureTask).start();
        System.out.println("future get="+futureTask.get());

        System.out.println("End:" + System.currentTimeMillis());
        System.out.println("use time:" + (System.nanoTime() - nanotime));
    }

}
