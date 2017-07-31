package org.gitqh.CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-16:59
 */
public class ReportGenerator implements Callable<String> {

    private String sender;
    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        long duration = (long)(10 * Math.random());
        System.out.println(sender +"_"+title+": reportGenerator:"+duration);
        TimeUnit.SECONDS.sleep(duration);
        return sender+":"+title;
    }
}
