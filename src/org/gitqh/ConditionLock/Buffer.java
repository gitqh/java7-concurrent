package org.gitqh.ConditionLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-14:07
 */
public class Buffer {

    private LinkedList<String> buffer;
    private int maxSize;
    private Lock lock;
    private Condition lines;
    private Condition space;
    private Boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line){
        lock.lock();
        try {
            while (buffer.size() == maxSize){
                space.await();
            }
            buffer.offer(line);
            System.out.println(Thread.currentThread().getName() + " inserted line:"+buffer.size());
            this.lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public String get(){
        String line = null;
        lock.lock();
        try {
            while ((buffer.size()==0)&&(hasPendingLines())){
                lines.await();
            }
            if (hasPendingLines()){
                line = buffer.poll();
                System.out.println(Thread.currentThread().getName() + " line readed :"+buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size()>0;
    }
}
