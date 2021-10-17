package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadFutureTask extends ThreadSuper{
    public static void main(String[] args) throws Exception {
        final ThreadFutureTask futureTask = new ThreadFutureTask();
        futureTask.runThread();
    }
    public int invoke() throws Exception {
        final FiboCallable callable = new FiboCallable(36);
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        executorService.submit(futureTask);
        executorService.shutdown();
        return futureTask.get();
    }
}
