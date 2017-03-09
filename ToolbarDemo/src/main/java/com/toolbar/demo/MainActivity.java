package com.toolbar.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import builder.navigation.DefaultNavigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultNavigation navigationBar = new DefaultNavigation.Builder(this,
                (ViewGroup) findViewById(android.R.id.content))
//                .setLeftIcon(R.drawable.common_back)
                .setTitle("投稿")
//                .setRightText("发表")
                .create();
    }
}
