package org.example;

import java.util.concurrent.locks.LockSupport;

public class ThreadPark extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadPark threadPark = new ThreadPark();
        threadPark.runThread();
    }
    public int invoke() throws Exception {
        final Fibo fibo = new Fibo(36, Thread.currentThread());
        fibo.start();
        LockSupport.park();
        return fibo.sum();
    }
}
