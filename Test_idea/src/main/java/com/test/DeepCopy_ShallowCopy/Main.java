package com.test.deepCopy_shallowCopy;

/**
 * Created by iQiwen on 2019/4/26.
 */
public class Main   {

    public static void main(String[] args) {
        int apples = 5;
        int pears = apples;
        System.out.printf("apples=%d, pears=%d\n", apples, pears);
        pears = 6;
        System.out.printf("apples=%d, pears=%d", apples, pears);
    }
}
