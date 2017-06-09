package com.example.lambda;

/**
 * Created by bobo on 2017/6/9.
 */

public interface IExtend2 extends IExtend1 {
    default void kill() {
        System.out.println("IExtend2 kill");
    }
}
