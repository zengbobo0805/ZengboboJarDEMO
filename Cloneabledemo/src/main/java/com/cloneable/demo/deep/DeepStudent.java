package com.cloneable.demo.deep;

/**
 * Created by bobo on 2017/2/10.
 */

public class DeepStudent implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public DeepStudent clone() throws CloneNotSupportedException {
        return (DeepStudent) super.clone();
    }
}
