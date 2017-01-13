package com.zengbobo.eventBus.demo.com.zengbobo.eventBus.demo.event.vo;

/**
 * Created by bobo on 2017/1/13.
 */

public class Test2Event {
    private String name;

    public Test2Event(String name) {
        this.name = name;
    }

    public void println(String type) {
        System.out.println("Test2Event println name:" + name + ",type:" + type);
    }
}
