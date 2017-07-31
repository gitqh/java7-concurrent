package org.gitqh.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-22-21:08
 */
public class Main {
    public static void main(String[] args) {
        final int ROWS=10000;
        final int NUMBERS=1000;
        final int SEARCH=5;
        final int PARTICIPANTS=5;
        final int LINES_PARTICIPANT=2000;
        MatrixMock mock = new MatrixMock(ROWS,NUMBERS,SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);
        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i=0;i<PARTICIPANTS;i++){
            searchers[i] = new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,
                    mock,results,PARTICIPANTS,barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.println("main thread has finished");
    }
}
