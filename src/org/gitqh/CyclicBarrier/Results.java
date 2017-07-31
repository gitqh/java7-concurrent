package org.gitqh.CyclicBarrier;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-20:59
 */
public class Results {

    private int data[];

    public Results(int size){
        data = new int[size];
    }

    /**
     *
     * @param position array的位置
     * @param value    array的值
     */
    public void setData(int position, int value){
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
