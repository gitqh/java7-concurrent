package org.gitqh.ConditionSynchronized;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:13
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0; i<100;i++){
            storage.get();
        }
    }
}
