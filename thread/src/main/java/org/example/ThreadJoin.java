package org.example;

public class ThreadJoin extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadJoin test1 = new ThreadJoin();
        test1.runThread();
    }

    public int invoke() throws Exception {
        final Fibo fibo = new Fibo(36);
        fibo.start();
        fibo.join();
        return fibo.sum();
    }
}
