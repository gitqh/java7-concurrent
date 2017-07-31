package org.gitqh.FutureCancel;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-12:24
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.println("task:test");
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
