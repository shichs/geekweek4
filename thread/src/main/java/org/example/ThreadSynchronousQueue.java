package org.example;

import java.util.concurrent.SynchronousQueue;

public class ThreadSynchronousQueue extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadSynchronousQueue synchronousQueue = new ThreadSynchronousQueue();
        synchronousQueue.runThread();
    }
    public int invoke() throws Exception {
        final SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<Integer>();
        final Fibo fibo = new Fibo(36, synchronousQueue);
        fibo.start();
        return synchronousQueue.take();
    }
}
