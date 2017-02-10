package com.cloneable.demo.shallow;

/**
 * Created by bobo on 2017/2/10.
 */

public class ShallowClass implements Cloneable{
    private String name;
    private ShallowStudent student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShallowStudent getStudent() {
        return student;
    }

    public void setStudent(ShallowStudent student) {
        this.student = student;
    }

    @Override
    public ShallowClass clone() throws CloneNotSupportedException {
        return (ShallowClass) super.clone();
    }
}
