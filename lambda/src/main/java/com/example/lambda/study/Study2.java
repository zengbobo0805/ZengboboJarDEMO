package com.example.lambda.study;

import com.example.lambda.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by bobo on 2017/6/9.
 *
 */

public class Study2 {

    public static void main(String args[]) {
        studyLambda();
    }

    /**
     * 5. 目标类型的上下文（Contexts for target typing）
     */
    public static void studyLambda() {
        List<Student> list = new ArrayList<>();
        Stream<String> names = list.stream().map(p -> p.getName());
    }




}
