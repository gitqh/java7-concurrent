package org.gitqh.ForkJoin2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-31-11:34
 */
public class DocumentTask extends RecursiveTask<Integer> {
    private String[][] document;
    private int start ,end;
    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if ((end -start )<50){
            result = processLines(document,start,end,word);
        }else {
            int mid = (start + end)/2;
            DocumentTask t1 = new DocumentTask(document,start,mid,word);
            DocumentTask t2 = new DocumentTask(document,mid,end,word);
            invokeAll(t1,t2);
            try {
                result = groupResults(t1.get(),t2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private int groupResults(Integer integer, Integer integer1) {
        return integer+integer1;
    }

    private int processLines(String[][] document, int start, int end, String word){
        List<LineTask> lineTasks = new ArrayList<>();
        for (int i=start;i<end;i++){
            LineTask task = new LineTask(document[i],0,document[i].length,word);
            lineTasks.add(task);
        }
        invokeAll(lineTasks);
        int result = 0;
        for (LineTask task : lineTasks) {
            try {
                result = result + task.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
