package org.gitqh.FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-16:25
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ResultTask[] resultTasks = new ResultTask[5];
        for (int i=0;i<5;i++) {
            Task task = new Task("task "+i);
            resultTasks[i] = new ResultTask(task);
            service.submit(resultTasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ResultTask resultTask : resultTasks) {
            resultTask.cancel(true);
        }
        for (ResultTask resultTask : resultTasks) {
            if (!resultTask.isCancelled()) {
                System.out.println(resultTask.get());
            }
        }
        service.shutdown();
    }
}
