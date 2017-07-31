package org.gitqh.ConditionSynchronized;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-12:05
 */
public class EventStorage {

    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        maxSize=10;
        storage=new LinkedList<>();
    }

    public synchronized void set(){
        while (storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        storage.add(new Date());
        System.out.println("set: "+storage.size());
        notifyAll();
    }

    public synchronized void get(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("get: " + storage.size() + ":" + ((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
