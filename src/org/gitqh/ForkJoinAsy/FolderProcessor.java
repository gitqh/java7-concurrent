package org.gitqh.ForkJoinAsy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-31-15:14
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

    private static final long serivalVersionUID = 1L;
    private String path;
    private String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();
        File file = new File(path);
        File[] content = file.listFiles();
        if (content !=null){
            for (int i=0;i<content.length;i++) {
                if (content[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(),extension);
                    task.fork();
                    tasks.add(task);
                }else {
                    if (checkFile(content[i].getName())) {
                        list.add(content[i].getAbsolutePath());
                    }
                }
            }
        }
        if (tasks.size()>50) {
            System.out.println(file.getAbsolutePath() + " : tasks ran " + "with "+ tasks.size());
        }
        addResultsFromTask(list, tasks);
        return list;
    }

    private void addResultsFromTask(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor task:tasks) {
            list.addAll(task.join());
        }
    }

    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }
}
