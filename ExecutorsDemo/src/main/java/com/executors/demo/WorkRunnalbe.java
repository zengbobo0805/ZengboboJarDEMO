package com.executors.demo;

/**
 * Created by bobo on 2017/2/10.
 */

public class WorkRunnalbe implements Runnable {
    private int index;
    private String name;

    public WorkRunnalbe(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("WorkRunnalbe start "
                + Thread.currentThread().getName() + ",index:" + index + ",name:" + name+"  "+this);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("WorkRunnalbe end "
                + Thread.currentThread().getName() + ",index:" + index + ",name:" + name+"  "+this);
    }
}
