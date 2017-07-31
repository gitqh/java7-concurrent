package org.gitqh.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-23:12
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<10;i++){
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        do {
            System.out.println("main: number of completed tasks: " + executor.getCompletedTaskCount());
            for (int i=0;i<resultList.size();i++){
                Future<Integer> result = resultList.get(i);
                System.out.println("main: task "+ i + " " + result.isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());
        System.out.println("main: results");
        for (int i=0;i<resultList.size();i++){
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("main: task "+i+" : " + number);
        }
        executor.shutdown();
    }



}
