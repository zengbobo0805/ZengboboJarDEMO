package com.example.lambda;

/**
 * Created by bobo on 2017/6/9.
 */

public interface ICallBackT<T> {
    public void onCallBack(T t);

    default int aaa() {
        return 0;
    }

}
