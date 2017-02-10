package com.cloneable.demo.deep;

/**
 * Created by bobo on 2017/2/10.
 */

public class DeepClass implements Cloneable {
    private String name;
    private DeepStudent student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepStudent getStudent() {
        return student;
    }

    public void setStudent(DeepStudent student) {
        this.student = student;
    }

    @Override
    public DeepClass clone() throws CloneNotSupportedException {
        DeepClass deep = (DeepClass) super.clone();
        deep.setStudent(deep.getStudent().clone());

        return deep;
    }
}
