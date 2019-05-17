package com.test.testSPI;

/**
 * Created by LX on 2015/3/8.
 */
public class PlusOperationImpl implements IOperation {

    @Override
    public int operation(int numberA, int numberB) {
        return numberA + numberB;
    }
}