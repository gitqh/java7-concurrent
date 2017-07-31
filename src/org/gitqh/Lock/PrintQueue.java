package org.gitqh.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:29
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object doc){
        queueLock.lock();
        Long duration = (long)(Math.random()*10000);
        System.out.println(Thread.currentThread().getName() + ": printqueue: printing a job during " +(duration/1000) + "seconds");
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
