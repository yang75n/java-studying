package com.yqw.java.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class Main {
    public static void main(String[] args) throws Exception {
        //Java内省机制，其实就是获取类的属性和属性类型
        //1，获取JavaBean的描述对象
        BeanInfo beanInfo = Introspector.getBeanInfo(IntrospectorBean.class, Object.class);
        //2，获取JavaBean中的属性的描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        //3，打印出来
        for (PropertyDescriptor pd : pds) {
            System.out.println("属性名：" + pd.getName());
            System.out.println("Getter：" + pd.getReadMethod());
            System.out.println("Setter：" + pd.getWriteMethod());
            System.out.println("----------------------------------");
            //属性是可以执行的，这应该就是反射了
            System.out.println(pd.getReadMethod().invoke(new IntrospectorBean()));
            System.out.println("----------------结束---------------");
        }
    }
}