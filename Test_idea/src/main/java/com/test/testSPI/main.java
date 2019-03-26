package com.test.testSPI;

import java.util.Iterator;
import java.util.ServiceLoader;

public class main {

    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();
        IOperation division = new DivisionOperationImpl();
        System.out.println(plus.operation(5, 3));
        System.out.println(division.operation(9, 3));

        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();

        System.out.println("classPath:" + System.getProperty("java.class.path"));

        while (operationIterator.hasNext()) {
            System.out.println("operationIterator item");
            IOperation operation = operationIterator.next();
            System.out.println("SPI result=" + operation.operation(6, 3));
        }
    }
}