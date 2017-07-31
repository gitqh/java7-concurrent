package org.gitqh;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-0:06
 */
public class SafeTask implements Runnable {

    public static void main(String[] args) {
        SafeTask task=new SafeTask();
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

    private static ThreadLocal<Date> startDate = ThreadLocal.withInitial(Date::new);

    @Override
    public void run() {
        System.out.println("starting thread : "+Thread.currentThread().getId()+" :" + startDate.get());
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread finished : " + Thread.currentThread().getId() + " : "+startDate.get());

    }
}
