package org.gitqh.CompletionService;

import java.util.concurrent.*;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-16:59
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> service1 = new ExecutorCompletionService<String>(service);
        ReportRequest faceRequest = new ReportRequest("Face",service1);
        ReportRequest onlineRequest = new ReportRequest("Online",service1);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);
        ReportProcessor processor = new ReportProcessor(service1);
        Thread senderThread = new Thread(processor);
        System.out.println("starting the threads");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        try {
            System.out.println("waiting for the report generators");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("shutting down the executor");
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        processor.setEnd(true);
    }
}
