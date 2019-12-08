package com.yqw.java.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Java8Tester {
    public static void main(String args[]) {


        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("W3CSchool ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("W3CSchool ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用 Java 7 语法: ");

        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");

        tester.sortUsingJava8(names2);
        System.out.println(names2);

        System.out.println("遍历name1:");
        //遍历
        //方法一
        System.out.println("方法一");
        for (String x : names1) {
            Java8Tester.sout(x);
        }
        //方法二
        System.out.println("方法二");
        names1.forEach((x) -> {
            Java8Tester.sout(x);
        });
        //方法三
        System.out.println("方法三");
        names1.forEach(Java8Tester::sout);
        //方法四
        System.out.println("方法四");
        Consumer<String> methodParam = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        names1.forEach(methodParam);
        //方法五
        System.out.println("方法五");
        Consumer<String> methodParam2 = Java8Tester::sout; //方法参数
        names1.forEach(methodParam2);
        //方法六
        System.out.println("方法六");
        names1.forEach(x -> {
            methodParam2.accept(x);
        });



    }


    public static void sout(String s) {
        System.out.println(s);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}