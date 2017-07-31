package org.gitqh.ForkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-31-0:28
 */
public class Main {
    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> productList = generator.generate(10000);
        Task task = new Task(productList, 0, productList.size(),0.20);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n",pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  while (!task.isDone());
        pool.shutdown();
        for (Product product : productList) {
            if (product.getPrice() != 12) {
                System.out.println("product " + product.getName() + ":" + product.getPrice());
            }
        }
        System.out.println("main: end of the program");
    }
}
