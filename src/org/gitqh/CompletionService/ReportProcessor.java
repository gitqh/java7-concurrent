package org.gitqh.CompletionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-17:05
 */
public class ReportProcessor implements Runnable {
    private CompletionService<String> service;
    private boolean end;

    public void setEnd(boolean end) {
        this.end = end;
    }

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                Future<String> future = service.poll(20, TimeUnit.SECONDS);
                if (future!=null){
                    String report = future.get();
                    System.out.println("reportReceiver: report received:"+report);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("reportSender:end");
    }
}
