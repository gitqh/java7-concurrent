package org.gitqh;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-16:41
 */
public class FileClock implements Runnable {

    public static void main(String[] args) {
        Thread task = new Thread(new FileClock());
        task.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
//        try {
//            task.wait(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void run() {
        for (int i=0;i<15 ;i++){
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("the fileclock has been interrupted");
            }
        }
    }
}
