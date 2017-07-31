package org.gitqh.CyclicBarrier;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-21:06
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult=0;
        System.out.println("grouper: processing results...");
        int[] data = results.getData();
        for (int number:data){
            finalResult+=number;
        }
        System.out.println("grouper: total result: "+finalResult);
    }
}
