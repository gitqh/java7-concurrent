package org.gitqh.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-22:36
 */
public class Task extends RecursiveAction {
    private static final long serivalVersionUID = 1L;

    private List<Product> productList;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> productList, int first, int last, double increment) {
        this.productList = productList;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if ((last -first) < 10) {
            updatePrices();
        } else {
            int middle = (first + last)/2;
            System.out.println("task:pending tasks "+ getQueuedTaskCount());
            Task t1 = new Task(productList, first, middle+1,increment);
            Task t2 = new Task(productList, middle+1, last, increment);
            invokeAll(t1,t2);
        }
    }

    private void updatePrices() {
        for (int i=first;i<last;i++){
            Product product = productList.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
