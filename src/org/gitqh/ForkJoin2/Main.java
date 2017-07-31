package org.gitqh.ForkJoin2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-31-11:29
 */
public class Main {
    public static void main(String[] args) {
        DocumentMock mock = new DocumentMock();
        int lineNum = 1000;
        int wordNum = 1000;
        String word = "the";
        String[][] document = mock.generateDocument(lineNum,wordNum,word);
        long startTime = System.currentTimeMillis();
        DocumentTask task = new DocumentTask(document, 0,lineNum,word);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());
        try {
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        try {
            System.out.println("Main: The word appears %d in the document "+task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("main: the word number is: " +task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime- startTime);


        System.out.println("____________________________________________________________");
        long startTime1 = System.currentTimeMillis();
        int counter1 = 0;
        for (int i=0;i<lineNum;i++) {
            for (int j=0;j<wordNum;j++){
                if (document[i][j].equals(word)){
                    counter1++;
                }
            }
        }
        System.out.println("main: the word number is: "+counter1);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1- startTime1);
    }
}
