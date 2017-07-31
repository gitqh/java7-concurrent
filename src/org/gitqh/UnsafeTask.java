package org.gitqh;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:58
 */
public class UnsafeTask implements Runnable {

    public static void main(String[] args) {
        UnsafeTask task=new UnsafeTask();
        for (int i=0; i<10;i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.println("starting thread : "+Thread.currentThread().getId()+" :" + startDate);
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread finished : " + Thread.currentThread().getId() + " : "+startDate);
    }
}
