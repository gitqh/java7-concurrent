package org.gitqh.Lock;

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
        }
    }
}
