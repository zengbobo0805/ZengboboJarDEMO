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

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_1, tv_2, tv_3, tv_4;
    private TestSbuscriber1 test1Event;
    private TestSubscriber2 test2Event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
        register(true);
        initView();
    }

    private BaseSubscriberEvent.IEventBusSubscriber<TestSbuscriber1.Test1EventLayoutParam> testSub1
            = new BaseSubscriberEvent.IEventBusSubscriber<TestSbuscriber1.Test1EventLayoutParam>() {

        @Override
        public void onEventBus(TestSbuscriber1.Test1EventLayoutParam eventParams) {
            System.out.println("FirstActivity TestSbuscriber1 println name:"
                    + eventParams.getName());

        }
    };

    private BaseSubscriberEvent.IEventBusSubscriber<TestSubscriber2.Test2EventLayoutParam> testSub2
            = new BaseSubscriberEvent.IEventBusSubscriber<TestSubscriber2.Test2EventLayoutParam>() {

        @Override
        public void onEventBus(TestSubscriber2.Test2EventLayoutParam eventParams) {
            System.out.println("FirstActivity TestSubscriber2 println number:"
                    + eventParams.getNumber());

        }
    };

    private void register(boolean register) {
        if (test1Event == null) {
            test1Event = new TestSbuscriber1(testSub1);
        }
        if (test2Event == null) {
            test2Event = new TestSubscriber2(testSub2);
        }
        test1Event.register(register);
        test2Event.register(register);
    }

    private void initView() {
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setOnClickListener(this);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_2.setOnClickListener(this);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_3.setOnClickListener(this);
        tv_4 = (TextView) findViewById(R.id.tv_4);
        tv_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_1) {
            BaseSubscriberEvent.post(
                    new TestSbuscriber1.Test1EventLayoutParam.Test1EventBuild()
                            .setName("firstActivity")
                            .build());

        } else if (id == R.id.tv_2) {
            BaseSubscriberEvent.post(new TestSubscriber2.Test2EventLayoutParam.Test2EventBuild()
                    .setNumber(1)
                    .build());

        } else if (id == R.id.tv_3) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

        } else if (id == R.id.tv_4) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);

        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("FirstActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("FirstActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("FirstActivity onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("FirstActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("FirstActivity onDestroy");
        register(false);
    }
}
