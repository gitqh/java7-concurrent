package org.gitqh.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-16:34
 */
public class ResultTask extends FutureTask<String> {
    private String name;
    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((Task)callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()){
            System.out.println(name+" :has been canceled");
        } else {
            System.out.println(name +":has finished");
        }
    }
}
