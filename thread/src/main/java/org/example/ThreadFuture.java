package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadFuture extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadFuture future = new ThreadFuture();
        future.runThread();
    }
    public int invoke() throws Exception {
        final FiboCallable fibo = new FiboCallable(36);
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<Integer> submit = executorService.submit(fibo);
        executorService.shutdown();
        return submit.get();
    }
}
