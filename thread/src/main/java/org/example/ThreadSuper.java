package org.example;

public abstract class ThreadSuper {
    public void runThread() throws Exception {
        long start = System.currentTimeMillis();
        int result = invoke();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    public abstract int invoke() throws Exception;
}
