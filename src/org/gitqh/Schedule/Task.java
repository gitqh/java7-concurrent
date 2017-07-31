package org.gitqh.Schedule;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-29-18:00
 */
public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Date date = new Date();
        System.out.println(name +" : starting at "+ date);
        return "hello world";
    }
}
