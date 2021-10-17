package org.example;

public class ThreadNotify extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadNotify threadLock = new ThreadNotify();
        threadLock.runThread();
    }
    public int invoke() throws Exception {
        Object lock = new Object();
        final Fibo fibo = new Fibo(36, lock);
        fibo.start();
        synchronized (lock) {
            lock.wait();
        }
        return fibo.sum();
    }
}
