package org.example;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch extends ThreadSuper{
    CountDownLatch count = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {
        final ThreadCountDownLatch countDownLatch = new ThreadCountDownLatch();
        countDownLatch.runThread();
    }
    public int invoke() throws Exception {
        final Fibo fibo = new Fibo(36, count);
        fibo.start();
        count.await();
        return fibo.sum();
    }
}
