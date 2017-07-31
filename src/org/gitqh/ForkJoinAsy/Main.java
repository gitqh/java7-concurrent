package org.gitqh.ForkJoinAsy;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-31-15:14
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("D:\\08Work\\长城软件","txt");
        FolderProcessor apps = new FolderProcessor("G:\\Program Files","txt");
        FolderProcessor documents = new FolderProcessor("G:\\项目\\DI项目","txt");
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.
                    getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.
                    getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.
                    getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.
                    getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while((!system.isDone())||(!apps.isDone())||(!documents.
                isDone()));
        pool.shutdown();
        List<String> results;
        results=system.join();
        System.out.println("system "+results.size()+" files found");
        results = apps.join();
        System.out.println("apps "+results.size()+" files found");
        results = documents.join();
        System.out.println("documents "+results.size()+" files found");
    }

}
