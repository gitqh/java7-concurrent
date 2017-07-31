package org.gitqh.FireLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:32
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": going to print a doc");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + ": the doc has been printd");
    }
}
