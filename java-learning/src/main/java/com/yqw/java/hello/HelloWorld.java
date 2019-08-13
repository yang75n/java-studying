package com.yqw.java.hello;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by iQiwen on 2018/12/11.
 */
public class HelloWorld {

    @Test
    public void t7() {
        List<String> list = new ArrayList<String>();
        list.add("bcd");
        list.add("cde");
        list.add("def");
        list.add("abc");

        List<String> result = list.stream()
                //.parallel()
                .filter(e -> e.length() >= 3)
                .map(e -> e.charAt(0))
                //.peek(System.out :: println)
                //.sorted()
                //.peek(e -> System.out.println("++++" + e))
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("----------------------------");
        System.out.println(result);
    }


    @Test
    public void t6() {
        float f = 9;
        int i = 1;
        System.out.println(i >> 3);
        System.out.println(Float.floatToIntBits(f));
    }

    @Test
    public void t5() {
        int a = 9;
        int b = 8;
        used4t5(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public void used4t5(int a, int b) {
        a = b;
        b = a;
    }

    @Test
    public void t4() {
        System.out.println(233 % 8);
        System.out.println(233 % 8 ^ 5 ^ 5);
        System.out.println(233 % 8 | 5 | 5);
    }

    @Test
    public void t3() {
        try {
            System.out.println(System.getProperties());
            // int i = System.in.read();
            byte[] b = new byte[20];
            // System.out.println("i=" + i);
            System.out.println(new String(b));
            int j = System.in.read(b);
            System.out.println("j=" + j);
            System.out.println("b=" + Arrays.toString(b));

            b[0] = 97;
            b[1] = 113;
            System.out.println("b=" + Arrays.toString(b));
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2() {
        while (true) {
            try {
                System.out.println("Please input:");
                int i = System.in.read();
                System.out.println("i=" + i);
                // System.out.println("(char) i=" + (char) i);
                if (i == 113) {
                    System.out.println("q 閫�鍑�");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void t1() {
        String string[] = {};
        int i = 6;
        String string2[] = new String[i];
        System.out.println(string.length);
        System.out.println(string2.length);
        System.out.println(Arrays.toString(string2));
        String NULL = "";
        int[] arr = new int[3];
        System.out.println(NULL);
    }

    @Test
    public void t() {
        // 瀹氫箟鏁扮粍
        char[] char_arr = {'a', 'b', 'c', 'd', 'e'};
        for (int i = 0; i < char_arr.length; i++) {
            for (int j = 0; j < char_arr.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < char_arr.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < char_arr.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        for (int m = 0; m < char_arr.length; m++) {
                            if (m == i || m == j || m == k || m == l) {
                                continue;
                            }
                            // out.print(String.valueOf(char_arr[i]) +
                            // String.valueOf(char_arr[j]) +
                            // String.valueOf(char_arr[k]) +
                            // String.valueOf(char_arr[l]) +
                            // String.valueOf(char_arr[m]) + "<br>");
                            System.out.println(String.valueOf(char_arr[i]) + String.valueOf(char_arr[j])
                                    + String.valueOf(char_arr[k]) + String.valueOf(char_arr[l])
                                    + String.valueOf(char_arr[m]));
                        }
                    }
                }
            }
        }
    }


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