package org.gitqh.ReadAndWrite;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-13:12
 */
public class Writer implements Runnable {

    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println("modify the prices");
            pricesInfo.setPrices(Math.random()*10,Math.random()*8);
            System.out.println("modify finished");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
