package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class FiboCallable implements Callable<Integer> {
    private int a;
    private CompletableFuture<Integer> completableFuture;
    public FiboCallable(int a) {
        this.a = a;
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public Integer call() throws Exception {
        return fibo(a);
    }
}
