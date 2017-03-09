package com.zengbobo.eventBus.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zengbobo.eventBus.demo.R;
import com.zengbobo.eventBus.demo.event.BaseSubscriberEvent;
import com.zengbobo.eventBus.demo.event.TestSbuscriber1;
import com.zengbobo.eventBus.demo.event.TestSubscriber2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_1, tv_2, tv_3;
    private TestSbuscriber1 test1Event;
    private TestSubscriber2 test2Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register(true);
        initView();
    }

    private BaseSubscriberEvent.IEventBusSubscriber testSub1
            = new BaseSubscriberEvent.IEventBusSubscriber<TestSbuscriber1.Test1EventLayoutParam>() {

        @Override
        public void onEventBus(TestSbuscriber1.Test1EventLayoutParam eventParams) {
            System.out.println("MainActivity TestSbuscriber1 println name:"
                    + eventParams.getName());

        }
    };

    private BaseSubscriberEvent.IEventBusSubscriber testSub2
            = new BaseSubscriberEvent.IEventBusSubscriber<TestSubscriber2.Test2EventLayoutParam>() {

        @Override
        public void onEventBus(TestSubscriber2.Test2EventLayoutParam eventParams) {
            System.out.println("MainActivity TestSubscriber2 println number:"
                    + eventParams.getNumber());

        }
    };

    private void register(boolean register) {
//        if (test1Event == null) {
//            test1Event = new TestSbuscriber1(testSub1);
//        }
//        if (test2Event == null) {
//            test2Event = new TestSubscriber2(testSub2);
//        }
//        test1Event.register(register);
//        test2Event.register(register);
    }

    private void initView() {
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setOnClickListener(this);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_2.setOnClickListener(this);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_1) {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);

        } else if (id == R.id.tv_2) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

        } else if (id == R.id.tv_3) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);

        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        register(false);
    }


}
