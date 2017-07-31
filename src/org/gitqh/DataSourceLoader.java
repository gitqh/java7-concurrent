package org.gitqh;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-22:45
 */
public class DataSourceLoader implements Runnable {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DataSourceLoader(),"DataSourceThread");
        Thread thread2 = new Thread(new NetworkConnectionsLoader(),"NetworkConnectionsThread");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("configuration has been loaded "+ new Date());
    }

    @Override
    public void run() {
        System.out.println("beginning data sources loading "+ new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("data source loading finished " + new Date() );
    }
}
