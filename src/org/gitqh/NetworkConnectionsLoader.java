package org.gitqh;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-22:47
 */
public class NetworkConnectionsLoader implements Runnable {


    @Override
    public void run() {
        System.out.println("beginning network connection "+ new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("network connection finished " + new Date() );
    }
}
