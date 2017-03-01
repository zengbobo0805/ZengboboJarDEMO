package com.executors.demo.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bobo on 2017/3/1.
 */


public class TimerExceptionTest {
    public static void main(String[] args) throws InterruptedException {

        final TimerTask task1 = new TimerTask() {

            @Override
            public void run() {
                throw new RuntimeException();
            }
        };

        final TimerTask task2 = new TimerTask() {

            @Override
            public void run() {
                System.out.println("task2 invoked!");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task1, 100);
        timer.scheduleAtFixedRate(task2, new Date(), 1000);


    }
}

/*2、Timer当任务抛出异常时的缺陷
        如果TimerTask抛出RuntimeException，Timer会停止所有任务的运行：

        上面有两个任务，任务1抛出一个运行时的异常，任务2周期性的执行某个操作，输出结果：
D:\android_2016_4_26\Android_Studio\jre\bin\java -Didea.launcher.port=7534 -Didea.launcher.bin.path=D:\android_2016_4_26\Android_Studio\bin -Dfile.encoding=UTF-8 -classpath D:\android_2016_4_26\android_sdk\platforms\android-25\android.jar;D:\android_2016_4_26\android_sdk\platforms\android-25\data\res;D:\android_2016_4_26\ZengboboJarDemo\ExecutorsDemo\build\intermediates\classes\debug;D:\android_2016_4_26\android_sdk\extras\android\m2repository\com\android\support\support-annotations\25.1.0\support-annotations-25.1.0.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-compat\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-compat\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-fragment\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-fragment\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\animated-vector-drawable\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\animated-vector-drawable\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-v4\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-v4\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-core-ui\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-core-ui\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-media-compat\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-media-compat\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-vector-drawable\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-vector-drawable\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\appcompat-v7\25.1.0\res;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\appcompat-v7\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-core-utils\25.1.0\jars\classes.jar;D:\android_2016_4_26\ZengboboJarDemo\ActivityStartDemo\build\intermediates\exploded-aar\com.android.support\support-core-utils\25.1.0\res;D:\android_2016_4_26\Android_Studio\lib\idea_rt.jar com.intellij.rt.execution.application.AppMain com.executors.demo.test.TimerExceptionTest
task2 invoked!
Exception in thread "Timer-0" java.lang.RuntimeException
	at com.executors.demo.test.TimerExceptionTest$1.run(TimerExceptionTest.java:19)
	at java.util.TimerThread.mainLoop(Timer.java:555)
	at java.util.TimerThread.run(Timer.java:505)

由于任务1的一次，任务2也停止运行了。。。
        */
