package com.zengbobo.eventBus.demo.com.zengbobo.eventBus.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zengbobo.eventBus.demo.R;
import com.zengbobo.eventBus.demo.com.zengbobo.eventBus.demo.event.vo.Test1Event;
import com.zengbobo.eventBus.demo.com.zengbobo.eventBus.demo.event.vo.Test2Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_1, tv_2, tv_3,tv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
        register(true);
        initView();
    }

    private void register(boolean register){
        if(register){
            EventBus.getDefault().register(this);
        }else{
            EventBus.getDefault().unregister(this);
        }
    }

    private void initView(){
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
            EventBus.getDefault().post(new Test1Event("Test1Event First  "));

        } else if (id == R.id.tv_2) {
            EventBus.getDefault().post(new Test2Event("Test2Event First  "));

        } else if (id == R.id.tv_3) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

        } else if (id == R.id.tv_4) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);

        }
    }

    @Subscribe
    public void onEventMothod(Test1Event event) {
        if (event != null) {
            event.println(this.getClass().getName());
        }

    }

    @Subscribe
    public void onEventMothod(Test2Event event) {
        if (event != null) {
            event.println(this.getClass().getName());
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
