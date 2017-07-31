package org.gitqh.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-16:25
 */
public class Task implements Callable<String> {
    private String name;

    public String getName() {
        return name;
    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        long duration = (long)(Math.random()*10);
        System.out.printf("%s:waiting %d seconds for results\n",name,duration);
        TimeUnit.SECONDS.sleep(duration);
        return "hello,world! I'm "+name;
    }
}
