package com.executors.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private ExecutorService pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSingleThreadExecutor();
            }
        });
        findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCachedThreadExecutor();
            }
        });
        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickFixedThreadExecutor();
            }
        });
        findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void onClickSingleThreadExecutor() {
        if (onClickThreadExecutor()) {
            return;
        }else{
            pool = Executors.newSingleThreadExecutor();
        }
        for (int i = 0; i < 1000; i++) {

            System.out.println("MainActivity onClickSingleThreadExecutor " + i + "  " + pool.isShutdown());
            if (!pool.isShutdown()) {
                Runnable runnable = new WorkRunnalbe(i, "onClickSingleThreadExecutor");
                pool.execute(runnable);
            }
        }
    }

    private boolean onClickThreadExecutor() {
        if (pool == null) {
            return false;
        } else {
//            shutdown调用后，不可以再submit新的task，已经submit的将继续执行。
            pool.shutdown();
//            shutdownNow试图停止当前正执行的task，并返回尚未执行的task的list
            pool.shutdownNow();
            Toast.makeText(MainActivity.this, "again on click me", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private void onClickCachedThreadExecutor() {
        if (onClickThreadExecutor()) {
            return;
        }

        pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            if (!pool.isShutdown()) {
                Runnable runnable = new WorkRunnalbe(i, "onClickCachedThreadExecutor");
                pool.execute(runnable);
            }
        }
    }

    private void onClickFixedThreadExecutor() {
        if (onClickThreadExecutor()) {
            return;
        }

        pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            if (!pool.isShutdown()) {
                Runnable runnable = new WorkRunnalbe(i, "onClickFixedThreadExecutor");
                pool.execute(runnable);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyExecutorService();
    }

    private void onDestroyExecutorService() {
        if (pool != null
                && !pool.isShutdown()) {
            pool.shutdown();
        }
        pool = null;
    }
}
