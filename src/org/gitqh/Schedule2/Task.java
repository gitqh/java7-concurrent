package org.gitqh.Schedule2;

import java.util.Date;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-12:03
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n",name,new Date());
        System.out.println( "Hello, world");
    }
}
