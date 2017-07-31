package org.gitqh.Rejected;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-20:50
 */
public class RejectedTaskController implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: The task %s has been rejected\n",r.toString());
        System.out.printf("RejectedTaskController: %s\n",executor.toString());
        System.out.printf("RejectedTaskController: Terminating:%s\n",executor.isTerminating());
        System.out.printf("RejectedTaksController: Terminated:%s\n",executor.isTerminated());
    }
}
