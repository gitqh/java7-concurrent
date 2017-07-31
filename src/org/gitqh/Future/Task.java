package org.gitqh.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-29-17:29
 */
public class Task implements Callable<Result> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.println(this.name + ":starting");
        try {
            long duration = (long)(Math.random()*10);
            System.out.println(this.name+": waiting "+ duration + " seconds");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value=0;
        for (int i=0;i<5;i++){
            value+=(int)(Math.random()*100);
        }
        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        System.out.println(name+": ends");
        return result;
    }
}
