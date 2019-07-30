package com.yqw.java.testSPI;

/**
 * Created by LX on 2015/3/8.
 */
public class DivisionOperationImpl implements IOperation {
 
    @Override
    public int operation(int numberA, int numberB) {
        return numberA / numberB;
    }
}