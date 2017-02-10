package com.cloneable.demo.shallow;

/**
 * Created by bobo on 2017/2/10.
 */

public class ShallowStudent implements Cloneable{
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
    public ShallowStudent clone() throws CloneNotSupportedException {
        return (ShallowStudent) super.clone();
    }
}
