package org.gitqh;

import java.util.Random;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-0:25
 */
public class MyThreadGroupTask implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / ((int)(random.nextDouble()*1000));
            System.out.println(Thread.currentThread().getId() + ":" + result);
            if (Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getId()+" interrupted");
                return;
            }
        }
    }
}
