package org.gitqh.Schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-29-18:03
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        Date date = new Date();
        System.out.println("main starting at :" +date);
        for (int i=0;i<5;i++){
            Task task = new Task("task "+i);
            executor.schedule(task,i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println("main: ends at : "+date1);
    }
}
