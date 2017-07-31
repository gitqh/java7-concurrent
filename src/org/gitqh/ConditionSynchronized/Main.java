package org.gitqh.ConditionSynchronized;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:14
 */
public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Thread task1 = new Thread(new Producer(storage));
        Thread task2 = new Thread(new Consumer(storage));
        task1.start();
        task2.start();


        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
