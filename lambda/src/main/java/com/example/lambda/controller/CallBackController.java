package com.example.lambda.controller;

import com.example.lambda.ICallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/6/9.
 */

public class CallBackController {
    private List<ICallBack> list = new ArrayList<ICallBack>();

    public void addCallBack(ICallBack callBack) {
        list.add(callBack);
    }

    public void onCall() {
        for (ICallBack callBack : list) {
            callBack.onCallBack();
        }
    }
}
