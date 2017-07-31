package org.gitqh.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-22:54
 */
public class Server {

    private ThreadPoolExecutor executor;

    public Server() {
//        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.println("server: a new task has arrived");
        executor.execute(task);
        System.out.println("server: task count: " + executor.getTaskCount());
        System.out.println("server: pool size :"+executor.getPoolSize() );
        System.out.println("server: active count :" +executor.getActiveCount());
        System.out.println("server: completed tasks: "+executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
}
