package com.example.lambda.study;

import com.example.lambda.controller.CallBackController;

import java.io.FileFilter;
import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.concurrent.Callable;

/**
 * Created by bobo on 2017/6/9.
 */

public class Study1 {

    public static void main(String args[]) {
        studyLambda();
    }


    public static void studyLambda() {
        CallBackController controller = new CallBackController();
        controller.addCallBack(() -> System.out.println("Study1 first!"));
        controller.addCallBack(() -> System.out.println("Study1 sencond!"));
        controller.onCall();
    }

    //    4. 目标类型（Target typing）
    Comparable<String> comparable = x -> 1;
    Comparator<String> comparator = (x, y) -> x.compareToIgnoreCase(y);
    Callable<String> c = () -> "done";
    PrivilegedAction<String> a = () -> "done";
    FileFilter java = f -> f.getName().endsWith(".java");



}
