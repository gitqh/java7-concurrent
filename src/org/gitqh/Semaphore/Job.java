package org.gitqh.Semaphore;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-15:13
 */
public class Job implements Runnable {

    private PrintQueueAll printQueue;

    public Job(PrintQueueAll printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to print a job");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName()+" the doc has been printed");
    }
}
