package org.gitqh.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-29-17:33
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Task> tasks = new ArrayList<>();
        for (int i=0;i<3;i++){
            Task task = new Task(i+"");
            tasks.add(task);
        }
        List<Future<Result>> futures = null;
        try {
            futures = executorService.invokeAll(tasks,2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("main:printing the results");
        for (int i=0;i<futures.size();i++){
            Future<Result> future = futures.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName()+":"+result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
