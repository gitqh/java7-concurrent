package org.gitqh.CountDownLatch;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-20:33
 */
public class Main {

    public static void main(String[] args) {
        Videoconference videoconference = new Videoconference(10);
        Thread thread = new Thread(videoconference);
        thread.start();
        for (int i=0;i<10;i++){
            Participant p = new Participant(videoconference,"participant "+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
