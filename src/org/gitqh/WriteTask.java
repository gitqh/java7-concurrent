package org.gitqh;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:04
 */
public class WriteTask implements Runnable {

    private ArrayBlockingQueue<Event> deque;

    public WriteTask(ArrayBlockingQueue<Event> deque) {
        this.deque = deque;
    }

    public static void main(String[] args) {
        ArrayBlockingQueue <Event> deque = new ArrayBlockingQueue<Event>(100);
        WriteTask writeTask = new WriteTask(deque);
        for (int i=0;i<3;i++){
            Thread thread = new Thread(writeTask);
            thread.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("the thread %s has generated an event",Thread.currentThread().getId()));
            deque.add(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
