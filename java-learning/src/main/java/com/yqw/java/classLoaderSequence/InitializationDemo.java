package com.yqw.java.classLoaderSequence;

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }

    {
        System.out.println("爷爷在普通代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷~");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    {
        System.out.println("爸爸在普通代码块");
    }


    //注意有final和没有final的区别
    protected static int factor = 25;

    //主意有final和没有final的区别
    public static final String name = "字符串常量爸爸";


    public Father() {
        System.out.println("我是爸爸~");
    }


    //赋值静态变量的静态方法
    public static String staticMethod() {
        System.out.println("父亲执行了静态方法");
        return "给静态字段赋值了";
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    {
        System.out.println("儿子在普通代码块");
    }

    // public static int factor = 25;

    public Son() {
        System.out.println("我是儿子~");
    }


}

public class InitializationDemo {
    static {
        System.out.println("Demo在静态代码块");
    }

    {
        System.out.println("Demo在普通代码块");
    }

    public InitializationDemo() {
        System.out.println("我是Demo~");
    }

    public static void main(String[] args) {
        //System.out.println("爸爸的岁数:" + new Son().factor); //入口

        //   System.out.println("爸爸的岁数2:" + new Son().factor);

        System.out.println("爸爸的岁数3：" + Son.factor);

        //   System.out.println(Son.name);

    }

}