package org.gitqh.ReadAndWrite;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-13:11
 */
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +" price 1: " + pricesInfo.getPrice1());
            System.out.println(Thread.currentThread().getName() +" price 2: " + pricesInfo.getPrice2());
        }
    }
}
