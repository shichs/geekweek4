package org.example;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Fibo extends Thread {
    private int a;
    private int sum;
    private Object waitObject;
    private CountDownLatch countDownLatch;
    private Thread parkThread;
    private ReentrantLock reentrantLock;
    private Condition condition;
    private ArrayBlockingQueue<Integer> blockingQueue;
    private SynchronousQueue<Integer> synchronousQueue;
    private CyclicBarrier cyclicBarrier;
    public Fibo(int a) {
        this.a = a;
    }

    public Fibo(int a, CountDownLatch countDownLatch) {
        this.a = a;
        this.countDownLatch = countDownLatch;
    }

    public Fibo(int a, Object lock) {
        this.a = a;
        this.waitObject = lock;
    }

    public Fibo(int a, Thread parkThread) {
        this.a = a;
        this.parkThread = parkThread;
    }

    public Fibo(int a, ReentrantLock lock, Condition condition) {
        this.a = a;
        this.reentrantLock = lock;
        this.condition = condition;
    }

    public Fibo(int a, ArrayBlockingQueue<Integer> blockingQueue) {
        this.a = a;
        this.blockingQueue = blockingQueue;
    }

    public Fibo(int a, SynchronousQueue<Integer> synchronousQueue) {
        this.a = a;
        this.synchronousQueue = synchronousQueue;
    }

    public Fibo(int a, CyclicBarrier cyclicBarrier) {
        this.a = a;
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {

        if (waitObject != null) {
            methodWaitObject();
        } else if (countDownLatch != null) {
            methodCountDownLatch();
        } else if (parkThread != null) {
            methodParkThread();
        } else if (reentrantLock != null) {
            methodReentrantLock();
        } else if (blockingQueue != null) {
            methodBlockingQueue();
        } else if (synchronousQueue != null) {
            methodSynchronousQueue();
        } else if (cyclicBarrier != null) {
            methodCyclicBarrier();
        } else {
            sum = fibo(a);
        }
    }

    private void methodWaitObject() {
        synchronized (waitObject) {
            sum = fibo(a);
            waitObject.notifyAll();
        }
    }

    private void methodCountDownLatch() {
        sum = fibo(a);
        countDownLatch.countDown();
    }

    private void methodParkThread() {
        sum = fibo(a);
        LockSupport.unpark(parkThread);
    }

    private void methodReentrantLock() {
        reentrantLock.lock();
        try {
            sum = fibo(a);
            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void methodCyclicBarrier() {
        try {
            sum = fibo(a);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void methodBlockingQueue() {
        blockingQueue.add(fibo(a));
    }

    private void methodSynchronousQueue() {
        synchronousQueue.add(fibo(a));
    }




    public int sum() {
        return sum;
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
