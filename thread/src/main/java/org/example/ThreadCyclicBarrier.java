package org.example;

import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadCyclicBarrier cyclicBarrier = new ThreadCyclicBarrier();
        cyclicBarrier.runThread();
    }
    public int invoke() throws Exception {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        final Fibo fibo = new Fibo(36, cyclicBarrier);
        fibo.start();
        cyclicBarrier.await();
        return fibo.sum();
    }
}
