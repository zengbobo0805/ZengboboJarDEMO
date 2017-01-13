package com.zengbobo.eventBus.demo.com.zengbobo.eventBus.demo.event.vo;

/**
 * Created by bobo on 2017/1/13.
 */

public class Test1Event {
    private String name;

    public Test1Event(String name) {
        this.name = name;
    }

    public void println(String type){
        System.out.println("Test1Event println name:"+name+",type:"+type);
    }
}
