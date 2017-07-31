package org.gitqh;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-0:23
 */
public class MyThreadGroup extends ThreadGroup {

    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        MyThreadGroupTask task = new MyThreadGroupTask();
        for (int i=0;i<2;i++){
            Thread thread = new Thread(threadGroup,task);
            thread.start();
        }
    }

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("the thread %s has thrown an exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.println("Terminating the rest of the Threads");
        interrupt();
    }
}
