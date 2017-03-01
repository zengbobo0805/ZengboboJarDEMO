package com.executors.demo.test;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by bobo on 2017/3/1.
 */

public class ScheduledThreadPoolExecutorTest {
    private static long start;

    public static void main(String[] args) {
        /**
         * 使用工厂方法初始化一个ScheduledThreadPool
         */
        ScheduledExecutorService newScheduledThreadPool = Executors
                .newScheduledThreadPool(2);

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                try {

                    System.out.println("task1 invoked ! "
                            + (System.currentTimeMillis() - start));
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task2 invoked ! "
                        + (System.currentTimeMillis() - start));
            }
        };
        start = System.currentTimeMillis();
        newScheduledThreadPool.schedule(task1, 1000, TimeUnit.MILLISECONDS);
        newScheduledThreadPool.schedule(task2, 3000, TimeUnit.MILLISECONDS);
    }
}

/*输出结果：
task1 invoked ! 1003
task2 invoked ! 3001
        符合我们的预期结果。因为ScheduledThreadPool内部是个线程池，所以可以支持多个任务并发执行*/
