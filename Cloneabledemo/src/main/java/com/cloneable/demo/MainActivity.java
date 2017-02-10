package com.cloneable.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cloneable.demo.deep.DeepClass;
import com.cloneable.demo.deep.DeepStudent;
import com.cloneable.demo.shallow.ShallowClass;
import com.cloneable.demo.shallow.ShallowStudent;

/**
 * 浅克隆 与 深克隆；
 */
public class MainActivity extends AppCompatActivity {
    private TextView tv_1, tv_2, tv_3, tv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_4 = (TextView) findViewById(R.id.tv_4);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShallowStudent shallowStudent = new ShallowStudent();
                shallowStudent.setAge(22);
                shallowStudent.setName("张三");
                StringBuffer buf = new StringBuffer();
                buf.append("*******************浅克隆***********************");
                try {
                    ShallowStudent newShallowStudent = shallowStudent.clone();
                    newShallowStudent.setName("李四");
                    newShallowStudent.setAge(23);
                    buf.append("\nshallow clone:before shallowStudent:" + shallowStudent.getName()
                            + "  " + shallowStudent.getAge()
                            + "   \nafter newShallowStudent:" + newShallowStudent.getName()
                            + "  " + newShallowStudent.getAge()
                            + "   \nafter shallowStudent:" + shallowStudent.getName()
                            + "  " + shallowStudent.getAge());

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                ShallowClass shallowClass = new ShallowClass();
                shallowClass.setName("Eng");
                shallowClass.setStudent(shallowStudent);

                try {
                    ShallowClass newShallowClass = shallowClass.clone();
                    newShallowClass.setName("china");
                    newShallowClass.getStudent().setName("王五");
                    newShallowClass.getStudent().setAge(12);
                    buf.append("\nshallow clone:before shallowClass:" + shallowClass.getName()
                            + "  " + shallowClass.getStudent().getAge() + "  " + shallowClass.getStudent().getName()
                            + "   \nafter newShallowClass:" + newShallowClass.getName()
                            + "  " + newShallowClass.getStudent().getAge() + "  " + newShallowClass.getStudent().getName()
                            + "   \nafter shallowClass:" + shallowClass.getName()
                            + "  " + shallowClass.getStudent().getAge() + "  " + shallowClass.getStudent().getName());

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                buf.append("******************************************");
                tv_2.setText(buf);
            }
        });
        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeepStudent deepStudent = new DeepStudent();
                deepStudent.setAge(22);
                deepStudent.setName("张三");
                StringBuffer buf = new StringBuffer();
                buf.append("*********************深克隆*********************");
                try {
                    DeepStudent newDeepStudent = deepStudent.clone();
                    newDeepStudent.setName("李四");
                    newDeepStudent.setAge(23);

                    buf.append("\nDeep clone:before deepStudent:" + deepStudent.getName()
                            + "  " + deepStudent.getAge()
                            + "   \nafter newDeepStudent:" + newDeepStudent.getName()
                            + "  " + newDeepStudent.getAge()
                            + "   \nafter deepStudent:" + deepStudent.getName()
                            + "  " + deepStudent.getAge());

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                DeepClass deepClass = new DeepClass();
                deepClass.setName("Eng");
                deepClass.setStudent(deepStudent);

                try {
                    DeepClass newDeepClass = deepClass.clone();
                    newDeepClass.setName("china");
                    newDeepClass.getStudent().setName("王五");
                    newDeepClass.getStudent().setAge(12);
                    buf.append("\nDeep clone:before deepClass:" + deepClass.getName()
                            + "  " + deepClass.getStudent().getAge() + "  " + deepClass.getStudent().getName()
                            + "   \nafter newShallowClass:" + newDeepClass.getName()
                            + "  " + newDeepClass.getStudent().getAge() + "  " + newDeepClass.getStudent().getName()
                            + "   \nafter deepClass:" + deepClass.getName()
                            + "  " + deepClass.getStudent().getAge() + "  " + deepClass.getStudent().getName());

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                buf.append("******************************************");
                tv_4.setText(buf);
            }
        });
    }
}
