package org.gitqh.Rejected;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-20:50
 */
public class Main {
    public static void main(String[] args) {
        RejectedTaskController controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);
        System.out.println("main:starting");
        for (int i=0;i<3;i++){
            Task task = new Task("task "+i);
            executor.submit(task);
        }
        System.out.println("main:shutting down the executor");
        executor.shutdown();
        System.out.println("main:sending another task");
        executor.submit(new Task("RejecteTask"));
        System.out.println("end");
    }
}
