package com.test.tryCatchFinally;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iQiwen on 2018/12/13.
 */
public class TestTry {


    public static void main(String s[]) {
        System.out.println("###########test1###############");
        System.out.println("test1=" + test1());
        System.out.println("###########test2###############");
        System.out.println("test2=" + test2());
        System.out.println("###########test3###############");
        System.out.println("test3=" + test3());
        System.out.println("###########test4###############");
        System.out.println("test4=" + test4());
        System.out.println("###########test5###############");
        System.out.println("test5=" + test5());

    }

    /**
     * 总结：finally代码块是在try代码块中的return语句执行之后，返回之前执行的。
     *
     * @return
     */
    public static int test1() {

        int i = 0;

        try {

            System.out.println("try...");

            return i += 10;

        } catch (Exception e) {

            System.out.println("catch...");

        } finally {

            i++;

            i = 0;//此时修改不影响返回值。（传地址的修改才会对返回值有效，参见test3）

            System.out.println("finally...");

            System.out.println("i=" + i);


        }

        return -1;

    }

    /**
     * 总结：finally代码块中的return语句覆盖try代码块中的return语句。
     *
     * @return
     */
    private static int test2() {

        int i = 0;

        try {

            System.out.println("try...");

            return i += 10;

        } catch (Exception e) {

            System.out.println("catch...");

        } finally {

            i++;

            System.out.println("finally...");

            System.out.println("i=" + i);

            return -1;

        }

    }

    /**
     * 总结： 如果finally语句中没有return语句覆盖返回值，那么原来的返回值可能因为finally里的修改而改变也可能不变。传值类型的返回值：不变；传址类型的返回值：会变。
     * <p/>
     * 这里引入来一个新的问题，怎么判断一个变量是传值还是传址？传值：8种基本数据类型及其包装类，字符常量。传址：数组和对象。
     *
     * @return
     */
    private static Map<String, String> test3() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("KEY", "INIT");

        try {

            System.out.println("try...");

            map.put("KEY", "TRY");

            return map;

        } catch (Exception e) {

            System.out.println("catch...");

            map.put("KEY", "CATCH");

        } finally {

            System.out.println("finally...");
            map.put("KEY", "FINALLY");//此修改影响返回值
            map = null;//此修改不影响返回值

        }

        return map;

    }

    /**
     * 总结： try代码块中的return语句在异常的情况下不会被执行，这样具体返回哪个看情况；catch中的return执行情况与未发生异常时try中return的执行情况完全一样。
     *
     * @return
     */
    private static int test4() {

        int i = 1;

        try {

            System.out.println("try...");

            i = i / 0;

            return i += 10;

        } catch (Exception e) {

            System.out.println("catch...");

            return i;

        } finally {

            i++;

            System.out.println("finally...");

            System.out.println("i=" + i);

        }

    }


    /**
     * 总结:finally代码块中的return语句覆盖try代码块或catch代码块中的return语句。
     *
     * @return
     */
    private static int test5() {
        int i = 1;
        try {
            System.out.println("try...");
            i = i / 0;
            return i += 10;
        } catch (Exception e) {
            System.out.println("catch...");
            return i;
        } finally {
            i++;
            System.out.println("finally...");
            System.out.println("i=" + i);
            return -1;
        }
    }

}