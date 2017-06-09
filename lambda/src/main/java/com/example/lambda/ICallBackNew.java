package com.example.lambda;

/**
 * Created by bobo on 2017/6/9.
 */

public interface ICallBackNew<T> {
    public  T onCallBack(int age,String name);
    default int aaa() {
        return 0;
    }

}
