package com.example.lambda.study;

import com.example.lambda.ICallBack;
import com.example.lambda.ICallBackNew;
import com.example.lambda.ICallBackT;
import com.example.lambda.IExtend1;
import com.example.lambda.IExtend2;
import com.example.lambda.controller.ExtendController;
import com.example.lambda.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by bobo on 2017/6/9.
 */

public class Study3 {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public String toString() {
        return "Hello, world";
    }


    public static void main(String... args) {
//        run1();
//        try {
//            System.out.println(run2("Study3").call());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        run3();
//        run4();
//        run5();
        run6();
    }

    /**
     * 6. 词法作用域（Lexical scoping）
     */
    public static void run1() {
        new Study3().r1.run();
        new Study3().r2.run();
//        运行打印：
//        Hello, world
//        Hello, world
//
//        Process finished with exit code 0

    }

    /**
     * 7. 变量捕获（Variable capture）
     *
     * @param name
     * @return
     */
    public static Callable<String> run2(String name) {
        String hello = "Hello";
        return () -> (hello + ", " + name);
    }

    /**
     * 7. 变量捕获（Variable capture）
     */
    public static void run3() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "李四"));
        list.add(new Student(3, "王五"));
        list.forEach(s -> {
            System.out.println(s.getName() + ":" + s.getAge());
        });
        int mapToInt = list.stream().mapToInt(s -> s.getAge()).sum();
        System.out.println("run3 mapToInt:" + mapToInt);

    }

    /**
     * 8. 方法引用（Method references）
     */
    public static void run4() {
        Comparator<Student> byName1 = Comparator.comparing(s -> s.getName());
        //等价；
        Comparator<Student> byName2 = Comparator.comparing(Student::getName);


        Consumer<Integer> b1 = System::exit;    // void exit(int status)
        Consumer<String[]> b2 = Arrays::sort;    // void sort(Object[] a)
        Consumer<String> b3 = Study3::main;  // void main(String... args)
        Runnable r = Study3::run3;        // void main(String... args)
    }

    /**
     * 9. 方法引用的种类（Kinds of method references）
     */
    public static void run5() {
//        方法引用有很多种，它们的语法如下：
//        静态方法引用：              ClassName::methodName
//        实例上的实例方法引用：       instanceReference::methodName
//        超类上的实例方法引用：       super::methodName
//        类型上的实例方法引用：       ClassName::methodName
//        构造方法引用：              Class::new
//        数组构造方法引用：           TypeName[]::new

        Map<String, Student> map1 = new HashMap<>();
        Set<String> knownNames1 = map1.keySet();
        Predicate<String> isKnown1 = knownNames1::contains;
        isKnown1.test("hshdh");

        Map<Student, String> map2 = new HashMap<>();
        Set<Student> knownNames2 = map2.keySet();
        ICallBack stu = knownNames2::size;
        stu.onCallBack();

        ICallBackNew<Student> st = Student::new;
        ICallBackT<Student> iCallBackT = t -> System.out.println(t.getAge() + ":" + t.getName());
        iCallBackT.onCallBack(st.onCallBack(1, "ICallBackNew"));
    }

    /**
     * 10. 默认方法和静态接口方法（Default and static interface methods）
     * 11. 继承默认方法（Inheritance of default methods）
     */
    public static void run6() {
        IExtend1 extend1 = () -> System.out.println("run6 IExtend1");
        IExtend2 extend2 = () -> System.out.println("run6 IExtend2");
        ExtendController extendController = new ExtendController();
        extend1.onCall();
        extend1.kill();
        extend2.onCall();
        extend2.kill();
        extendController.kill();
    }
}
