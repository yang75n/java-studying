package com.yqw.java.deepCopy_shallowCopy;

class StudentCloneable implements Cloneable {
    private int number;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public Object clone() {
        StudentCloneable stu = null;
        try {
            stu = (StudentCloneable) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}


public class TestClone {

    public static void main(String args[]) {

        StudentCloneable stu1 = new StudentCloneable();
        stu1.setNumber(12345);
        stu1.setName("张三");

        StudentCloneable stu2 = (StudentCloneable) stu1.clone();

        System.out.println("学生1:" + stu1.getNumber() + " " + stu1.getName());
        System.out.println("学生2:" + stu2.getNumber() + " " + stu2.getName());

        stu2.setNumber(54321);
        stu2.setName("李四");

        System.out.println("学生1:" + stu1.getNumber() + " " + stu1.getName());
        System.out.println("学生2:" + stu2.getNumber() + " " + stu2.getName());

        System.out.println(stu1 == stu2);
    }
}