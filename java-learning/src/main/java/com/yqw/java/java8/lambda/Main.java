package com.yqw.java.java8.lambda;

import org.junit.Test;

/**
 * Created by iQiwen on 2019/5/10.
 */
public class Main {

    @Test
    public void test() {
        //  将数字字符串转换为整数类型
        //创建Converter匿名对象；相当于new converter(){ @overwrite(){}}
        //Converter<String, Integer> converter = (String from) -> { return Integer.valueOf(from)};

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass()); //class java.lang.Integer
        System.out.println(converted); //class java.lang.Integer

    }


    /**
     * 方法和构造函数引用(Method and Constructor References)
     */
    @Test
    public void test1() {
        //通过静态方法引用来表示 (::)
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass());   //class java.lang.Integer
    }


    @Test
    public void test2() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);    // "J"
    }


    class Something {
        String startsWith(String s) {
            System.out.println("startWith s=" + s);
            return String.valueOf(s.charAt(0));
        }
    }

    /**
     * 我们只需要使用 Person::new 来获取Person类构造函数的引用，
     * Java编译器会自动根据PersonFactory.create方法的参数类型来选择合适的构造函数。
     */
    @Test
    public void test3() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }


    class Person {
        String firstName;
        String lastName;

        Person() {
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

}
