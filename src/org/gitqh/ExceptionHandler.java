package org.gitqh;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:50
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("an exception has been captured");
        System.out.println("thread "+ t.getId());
        System.out.println("exception: "+ e.getClass().getName() + " : " +e.getMessage());
//        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
