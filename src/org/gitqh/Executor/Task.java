package org.gitqh.Executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-22:50
 */
public class Task implements Runnable {

    private Date initDate;
    private String name;

    public Task(String name) {
        initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" created on " + initDate);
        System.out.println(Thread.currentThread().getName()+" started on " + new Date());
        Long duration = (long)(Math.random()*10);
        System.out.println(Thread.currentThread().getName() + " doing ad task during " +
                duration + " seconds");
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" finished " + name + " on "+ new Date());
    }
}
