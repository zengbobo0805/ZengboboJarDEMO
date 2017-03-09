package clwang.chunyu.me.testdetailrxandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * 我们已经熟悉了初步的使用方式, 在接着学习一些其他方法, 如
 * <p>
 * just: 获取输入数据, 直接分发, 更加简洁, 省略其他回调.
 * from: 获取输入数组, 转变单个元素分发.
 * map: 映射, 对输入数据进行转换, 如大写.
 * flatMap: 增大, 本意就是增肥, 把输入数组映射多个值, 依次分发.
 * reduce: 简化, 正好相反, 把多个数组的值, 组合成一个数据.
 * <p>
 * 更多的RxAndroid的使用方法.
 * <p>
 * Created by wangchenlong on 15/12/30.
 */
public class MoreActivity extends Activity implements View.OnClickListener{

    @Bind(R.id.simple_tv_text)
    TextView mTvText;



    @Bind(R.id.tv_1)
    TextView tv_1;

    @Bind(R.id.tv_2)
    TextView tv_2;

    @Bind(R.id.tv_3)
    TextView tv_3;

    final String[] mManyWords = {"Hello", "I", "am", "your", "friend", "Spike"};
    final List<String> mManyWordList = Arrays.asList(mManyWords);

    // Action类似订阅者, 设置TextView
    private Action1<String> mTextViewAction = new Action1<String>() {
        @Override
        public void call(String s) {
            mTvText.setText(s);
        }
    };

    // Action设置Toast
    private Action1<String> mToastAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Toast.makeText(MoreActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };

    // 设置映射函数
    private Func1<List<String>, Observable<String>> mOneLetterFunc = new Func1<List<String>, Observable<String>>() {
        @Override
        public Observable<String> call(List<String> strings) {
            return Observable.from(strings); // 映射字符串
        }
    };

    // 设置大写字母
    private Func1<String, String> mUpperLetterFunc = new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s.toUpperCase(); // 大小字母
        }
    };

    // 连接字符串
    private Func2<String, String, String> mMergeStringFunc = new Func2<String, String, String>() {
        @Override
        public String call(String s, String s2) {
            return String.format("%s %s", s, s2); // 空格连接字符串
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);
        tv_1.setText("just: 获取输入数据, 直接分发, 更加简洁, 省略其他回调.");
        tv_1.setOnClickListener(this);


        tv_2.setText("from: 获取输入数组, 转变单个元素分发");
        tv_2.setOnClickListener(this);

        tv_3.setText("just: 优化过的代码, 直接获取数组, 再分发, 再合并, 再显示toast, Toast顺次执行.");
        tv_3.setOnClickListener(this);






    }

    // 创建字符串
    private String sayMyName() {
        return "Hello, I am your friend, Spike!";
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id ==R.id.tv_1){
            // 添加字符串, 省略Action的其他方法, 只使用一个onNext.
            Observable<String> obShow = Observable.just(sayMyName());

            // 先映射, 再设置TextView
            obShow.observeOn(AndroidSchedulers.mainThread())
                    .map(mUpperLetterFunc)
                    .subscribe(mTextViewAction);


        }else  if(id ==R.id.tv_2){
            // 单独显示数组中的每个元素
            Observable<String> obMap = Observable.from(mManyWords);

            // 映射之后分发
            obMap.observeOn(AndroidSchedulers.mainThread())
                    .map(mUpperLetterFunc).subscribe(mToastAction);

        }else  if(id ==R.id.tv_3){
            // 优化过的代码, 直接获取数组, 再分发, 再合并, 再显示toast, Toast顺次执行.
            Observable.just(mManyWordList)
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(mOneLetterFunc)
                    .reduce(mMergeStringFunc)
                    .subscribe(mToastAction);
        }
    }
}
