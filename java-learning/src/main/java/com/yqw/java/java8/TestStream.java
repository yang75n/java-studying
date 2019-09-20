package com.yqw.java.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream:
 * 无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
 * 为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，
 * 而是会产生一个不包含被过滤元素的新stream。
 * 惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 * 可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 * 对stream的操作分为为两类，中间操作(intermediate operations)和结束操作(terminal operations)，二者特点是：
 * <p>
 * 中间操作总是会惰式执行，调用中间操作只会生成一个标记了该操作的新stream，仅此而已。
 * 结束操作会触发实际计算，计算发生时会把所有中间操作积攒的操作以pipeline的方式执行，
 * 这样可以减少迭代次数。计算完成之后stream就会失效。
 * Created by iQiwen on 2019/5/10.
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");


        // 测试 Filter(过滤)
        stringList
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);//aaa2 aaa1


        // 测试 Sort (排序)
        stringList
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// aaa1 aaa21
        System.out.println(stringList);// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1


        // 测试 Map 操作
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        // 测试 Match (匹配)操作
        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);      // true


        //测试 Count (计数)操作
        long startsWithB =
                stringList
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);    // 3


        //测试 Reduce (规约)操作
        Optional<String> reduced =
                stringList
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2


        //求最长字符串
        Stream<String> stream = Stream.of("1", "27", "3564");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        //Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());


        // 求单词长度之和
        Stream<String> stream2 = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream2.reduce(0,// 初始值　// (1)
                (sum, str) -> sum + str.length(), // 累加器 // (2)
                (a, b) -> a + b); // 部分和拼接器，并行执行时才会用到 // (3)
        // int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);


        // 将Stream转换成容器或Map。
        Stream<String> stream3 = Stream.of("I", "love", "you", "too");
        List<String> list = stream3.collect(Collectors.toList()); // (1)
        Set<String> set = stream3.collect(Collectors.toSet()); // (2)
        Map<String, Integer> map = stream3.collect(Collectors.toMap(Function.identity(), String::length)); // (3)
    }
}