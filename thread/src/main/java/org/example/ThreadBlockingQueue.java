package org.example;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadBlockingQueue extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadBlockingQueue blockingQueue = new ThreadBlockingQueue();
        blockingQueue.runThread();
    }
    public int invoke() throws Exception {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1);
        Fibo fibo = new Fibo(36, blockingQueue);
        fibo.start();
        //实际也是适用锁的机制实现线程阻塞
        return blockingQueue.take();
    }
}
