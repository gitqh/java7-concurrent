package org.gitqh.Semaphore;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-15:14
 */
public class Main {

//    public static void main(String[] args) {
//        PrintQueue printQueue = new PrintQueue();
//        Thread[] threads = new Thread[10];
//        for (int i=0;i<10;i++){
//            threads[i] = new Thread(new Job(printQueue),"thread "+i);
//        }
//        for (int i=0;i<10;i++){
//            threads[i].start();
//        }
//    }

    public static void main(String[] args) {

        PrintQueueAll printQueue = new PrintQueueAll();
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(new Job(printQueue),"thread "+i);
        }
        for (int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
