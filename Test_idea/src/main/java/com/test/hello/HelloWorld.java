package com.test.hello;

/**
 * Created by iQiwen on 2018/12/11.
 */
public class HelloWorld {
    public static void main(String args[]) {
        System.out.println("Hello,Test;Hello,idea;Hello,Maven");
        System.out.println(ClassLoader.getSystemClassLoader().toString());
        HelloWorld helloWorld = new HelloWorld();


        System.out.println( helloWorld.getClass()==HelloWorld.class);
        System.out.println( helloWorld.getClass());
        System.out.println( HelloWorld.class.toString());
        System.out.println(int.class);
        System.out.println(Integer.TYPE);

        float f = 3.4f;
        double d = 3.4;


    }
}
