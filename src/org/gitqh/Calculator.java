package org.gitqh;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-11:00
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i=1; i<=10;i++){
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(), number, i, i*number);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] status=new Thread.State[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(new Calculator(i));
            if (i%2==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread"+i);
        }
        
        try(FileWriter fileWriter = new FileWriter(".\\log.txt"); PrintWriter printWriter = new PrintWriter(fileWriter);){
            for (int i=0;i<10;i++){
                printWriter.println("main: status of thread "+i+" : "+threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i=0;i<10;i++){
                threads[i].start();
            }
            boolean finish = false;
            while (!finish){
                for (int i=0;i<10;i++){
                    if (threads[i].getState()!=status[i]){
                        writeThreadInfo(printWriter,threads[i],status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i=0;i<10;i++){
                    finish = finish && (status[i]== Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State status) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",status);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
