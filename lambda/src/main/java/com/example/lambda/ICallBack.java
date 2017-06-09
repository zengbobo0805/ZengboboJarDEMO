package com.example.lambda;

/**
 * Created by bobo on 2017/6/9.
 */

public interface ICallBack {
    public void onCallBack();

    default int aaa() {
        return 0;
    }


}
