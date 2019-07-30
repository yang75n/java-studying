package com.yqw.java.deepCopy_shallowCopy.deep;

class Address implements Cloneable {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public Object clone() {
        Address addr = null;
        try {
            addr = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr;
    }
}

class Student implements Cloneable {
    private int number;

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            stu = (Student) super.clone();   //浅复制
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        stu.addr = (Address) addr.clone();   //深度复制
        return stu;
    }
}

/**
 * 总结：浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对引用进行拷贝，
 * <p>
 * 没有对引用指向的对象进行拷贝。
 * <p>
 * 而深拷贝是指在拷贝对象时，同时会对引用指向的对象进行拷贝。
 * <p>
 * 区别就在于是否对  对象中的引用变量所指向的对象进行拷贝。
 * <p>
 * String 类型很特殊，它是不可变类型，即一旦初始化后，就不可以改变。因为他为引用型，而且他指向的值为常量，克隆出来的对象改变他的值
 * 实际上是改变了克隆出来对象String类型成员的指向，不会影响被克隆对象的。
 * 解释：如果原来对象的一个string变量进行初始化的时候，指向的是一个字符串常量，该字符串常量会被放到常量池中，
 * 该string类型的引用将会指向该常量。进行克隆后，得到一个新的对象，如果该对象的string变量重新赋值，那么只会
 * 有这个string 引用变量指向一个新的内存区域，对原来对象中的string变量不会有影响。
 */
public class Test {

    public static void main(String args[]) {

        Address addr = new Address();
        addr.setAdd("杭州市");
        Student stu1 = new Student();
        stu1.setNumber(123);
        stu1.setAddr(addr);

        Student stu2 = (Student) stu1.clone();

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

        addr.setAdd("西湖区");

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
    }
} 