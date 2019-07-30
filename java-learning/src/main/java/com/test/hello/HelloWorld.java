package com.test.hello;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by iQiwen on 2018/12/11.
 */
public class HelloWorld {


    @Test
    public void test3() throws IOException {
//        Logger.getLogger("nihao").log(Level.INFO, "woshi log");
//        Logger.getLogger("nihao").log(Level.SEVERE, "woshi log2");
//        Logger.getLogger("nihao").log(Level.ALL, "woshi log3");
    }


    @Test
    public void test2() {

        Stack<String> stack = new Stack<>();
        stack.push("nihao");
        stack.push("小明");
        stack.push(null);
        stack.push("小明");

        System.out.println(stack.toString());

    }

    @Test
    public void test() {
//
        System.out.println("Hello,Test;Hello,idea;Hello,Maven");
        System.out.println(ClassLoader.getSystemClassLoader().toString());
        HelloWorld helloWorld = new HelloWorld();
        String s = "fsdfsd";
        Integer one = 10;//100
        Integer two = 10;//100
        System.out.println(one == two);

//
        Integer total = 0;
        paramCheck(total);
        System.out.println("total =" + total);
//
        String[] array = {"a", "b"};
        System.out.println(Arrays.asList(array).size());

        for (int i = 0; i < iii(); i++) {
            System.out.println("aa");
        }

//
        Float totalMoney = 200000.0f;
        Float ownMoney = 170000.2f;
        Float leftMoney = totalMoney - ownMoney;
        System.out.println("还剩余：" + leftMoney);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        BigDecimal b1 = new BigDecimal(Float.toString(totalMoney));
        BigDecimal b2 = new BigDecimal(Float.toString(ownMoney));
        System.out.println("剩余" + b1.subtract(b2).floatValue());
//

        System.out.println("hash=" + s.hashCode());
        List<String> list = new ArrayList<String>();
        list.add("sdfsdf");
        List list1 = list;
        System.out.println(list + " ," + list.hashCode());
        list.set(0, "wowoo");
        System.out.println(list + " ," + list.hashCode());
        System.out.println(list1 + " ," + list1.hashCode());

        System.out.println(list == list1);




        String s1 = "sdf";
        String s2 = s1;
        System.out.println(s1 + " " + s2);

    }

    private static int iii() {
        System.out.println("wwwwwwwwwwww");
        return 3;
    }


    /**
     * @param total total
     */
    private static void paramCheck(Integer total) {
        if (total < 1) {
            total += 1;
        }
    }
}