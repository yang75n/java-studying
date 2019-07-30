package com.yqw.java.deepCopy_shallowCopy;

class Student {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

public class Test {

    public static void main(String args[]) {

        Student stu1 = new Student();
        stu1.setNumber(12345);

        Student stu2 = stu1;

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
        stu2.setNumber(2);
        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
    }
}