package org.gitqh.FutureCancel;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-12:24
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.println("main:executing the task");
        Future<String> future = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: canceling the task");
        future.cancel(true);
        System.out.println("main:canceled: "+future.isCancelled());
        System.out.println("main:done: "+future.isDone());
        executor.shutdown();
        System.out.println("main:the executor has finished");
    }
}
