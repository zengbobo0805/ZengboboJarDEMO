package com.rxandroid.demo;

import android.support.v7.app.AppCompatActivity;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by bobo on 2017/3/2.
 */

public class SimpleActivity extends AppCompatActivity {

    // 观察事件发生
    Observable.OnSubscribe mObservableAction = new Observable.OnSubscribe<String>() {

        @Override
        public void
        call(Subscriber<? super String> subscriber) {
            subscriber.onNext(sayMyName());
            // 发送事件

            subscriber.onCompleted();
            // 完成事件

        }
    };


    //创建字符串
    private String sayMyName() {

        return "Hello, I am your friend, Spike !";
    }
}
