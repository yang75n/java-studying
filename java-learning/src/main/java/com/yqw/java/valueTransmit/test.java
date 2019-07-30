package com.yqw.java.valueTransmit;

public class test {

    String s = "hello";

    char[] ch = {'a', 'b', 'c'};

    Character ck = 'k';

    /**
     * 可见，String类型是不会被修改的，在编译时，方法栈里有world，
     * 如果是输入赋值给String应该会变，char数组传递的是数组的引用，Character传递的是值
     * <p/>
     * 传值不会修改原来的，传引用会修改原来的。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        test tt = new test();

        tt.change(tt.s, tt.ch, tt.ck);

        System.out.println("--------");

        System.out.println("s+" + tt.s.hashCode());

        System.out.println("ch+" + tt.ch.hashCode());

        System.out.println("ck+" + tt.ck.hashCode());

        System.out.println("--------");

        System.out.println(tt.s);

        System.out.println(tt.ch);

        System.out.println(tt.ck);

    }

    public void change(String str, char[] ch, Character ck) {

        str = "world";

        ch[0] = 'd';

        ck = 'c';

        System.out.println("str+" + str.hashCode());

        System.out.println("ch+" + ch.hashCode());

        System.out.println("ckl+" + ck.hashCode());

    }

}