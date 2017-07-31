package org.gitqh.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-20:24
 */
public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.println(name + " has arrived");
        controller.countDown();
        System.out.println("waiting for "+controller.getCount());
    }

    @Override
    public void run() {
        System.out.println("initialization:"+controller.getCount());
        try {
            controller.await();
            System.out.println("all have come");
            System.out.println("let's start ...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
