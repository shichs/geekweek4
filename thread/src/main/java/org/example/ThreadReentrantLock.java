package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLock extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
        reentrantLock.runThread();
    }
    public int invoke() throws Exception {
        final ReentrantLock reentrantLock = new ReentrantLock(false);
        final Condition condition = reentrantLock.newCondition();
        final Fibo fibo = new Fibo(36, reentrantLock, condition);
        fibo.start();
        reentrantLock.lock();
        try {
            condition.await();
        } finally {
            reentrantLock.unlock();
        }
        return fibo.sum();
    }
}
