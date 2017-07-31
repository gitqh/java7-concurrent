package org.gitqh.CyclicBarrier;

import java.util.Random;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-20:54
 */
public class MatrixMock {

    private int data[][];

    /**
     *
     * @param size 矩阵行数
     * @param length 矩阵行长度
     * @param number 要查找的数字
     */
    public MatrixMock(int size, int length, int number){
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for (int i=0;i<size;i++) {
            for (int j=0;j<length;j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number){
                    counter++;
                }
            }
        }
        System.out.println("number "+ number +" : "+ counter);
    }

    public int[] getRow(int row){
        if ((row>=0)&&(row<data.length)){
            return data[row];
        }
        return null;
    }
}
