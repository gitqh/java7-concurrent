package org.gitqh;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-16:22
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("D:\\","备份定时.txt");
        Thread task = new Thread(searcher);
        task.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

    @Override
    public void run() {
        File file =new File(initPath);
        if (file.isDirectory()){
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("%s: the search has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        if (list!=null){
            for (File aList : list) {
                if (aList.isDirectory()) {
                    directoryProcess(aList);
                } else {
                    fileProcess(aList);
                }
            }
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)){
            System.out.printf("%s: %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
