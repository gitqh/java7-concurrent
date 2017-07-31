package org.gitqh.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-15:10
 */
public class PrintQueueAll {

    private final Semaphore semaphore;

    private boolean[] freePrinters;

    private Lock lockPrinters;

    public PrintQueueAll() {
        this.semaphore = new Semaphore(1);
        freePrinters = new boolean[3];
        for (int i=0;i<3;i++){
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object doc){
        try {
            semaphore.acquire();
            long duration = (long)(Math.random()*100);
            int assignedPrinter = getPrinter();
            System.out.println(Thread.currentThread().getName()+": printing a job in "+assignedPrinter +" during :"+duration);
            TimeUnit.MILLISECONDS.sleep(duration);
            freePrinters[assignedPrinter]=true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i=0;i<freePrinters.length;i++){
                if (freePrinters[i]){
                    ret = i;
                    freePrinters[i]=false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
