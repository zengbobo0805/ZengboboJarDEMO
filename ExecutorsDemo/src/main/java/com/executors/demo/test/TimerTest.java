package com.executors.demo.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bobo on 2017/3/1.
 */



public class TimerTest {

    private static long start;

    public static void main(String[] args) throws Exception
    {

        TimerTask task1 = new TimerTask()
        {
            @Override
            public void run()
            {

                System.out.println("task1 invoked ! "
                        + (System.currentTimeMillis() - start));
                try
                {
                    Thread.sleep(3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        };
        TimerTask task2 = new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("task2 invoked ! "
                        + (System.currentTimeMillis() - start));
            }
        };
        Timer timer = new Timer();
        start = System.currentTimeMillis();
        timer.schedule(task1, 1000);
        timer.schedule(task2, 3000);

    }
}
/*定义了两个任务，预计是第一个任务1s后执行，第二个任务3s后执行，但是看运行结果：
       task1 invoked ! 1001
       task2 invoked ! 4002

        task2实际上是4后才执行，正因为Timer内部是一个线程，而任务1所需的时间超过了两个任务间的间隔导致。
      */