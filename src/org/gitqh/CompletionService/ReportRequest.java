package org.gitqh.CompletionService;

import java.util.concurrent.CompletionService;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-30-17:03
 */
public class ReportRequest implements Runnable {
    private String name;
    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name,"report");
        service.submit(reportGenerator);
    }
}
