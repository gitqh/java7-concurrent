package org.gitqh.ConditionLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-14:33
 */
public class Main {

    public static void main(String[] args) {
        FileMock mock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(mock,buffer);
        Thread threadP = new Thread(producer,"procucer");

        Consumer[] consumers = new Consumer[3];
        Thread[] threadCs = new Thread[3];
        for (int i=0;i<3;i++){
            consumers[i] = new Consumer(buffer);
            threadCs[i] = new Thread(consumers[i],"consumer "+i);
        }

        threadP.start();
        for (int i=0;i<3;i++){
            threadCs[i].start();
        }
    }
}
