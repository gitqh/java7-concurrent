package org.gitqh.FireLock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:34
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(new Job(printQueue),"thread "+ i);
        }
        for (int i=0;i<10;i++){
            threads[i].start();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
