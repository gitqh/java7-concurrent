package org.gitqh;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:08
 */
public class CleanerTask extends Thread {

    private ArrayBlockingQueue<Event> deque;

    public CleanerTask(ArrayBlockingQueue<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.size()==0){
            return;
        }
        delete = false;
        do {
            Event e = deque.poll();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.println("Cleaner: "+ e.getEvent());
                deque.remove();
                delete = true;
            }
        } while (difference >10000);
        if (delete) {
            System.out.println("cleaner: size of the deque: "+ deque.size());
        }
        System.out.println("size of the deque: "+ deque.size());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
