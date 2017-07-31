package org.gitqh;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:53
 */
public class Task implements  Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
    }
}
