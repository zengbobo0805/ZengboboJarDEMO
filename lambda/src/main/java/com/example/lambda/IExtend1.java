package com.example.lambda;

/**
 * Created by bobo on 2017/6/9.
 */

public interface IExtend1 {
    public void onCall();

    default void kill(){
        System.out.println("IExtend1 kill");
    }
}
