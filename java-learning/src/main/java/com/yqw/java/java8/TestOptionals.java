package com.yqw.java.java8;

import java.util.Optional;

/**
 * Optionals不是函数式接口，而是用于防止 NullPointerException 的漂亮工具。这是下一节的一个重要概念，让我们快速了解一下Optionals的工作原理。
 * <p>
 * Optional 是一个简单的容器，其值可能是null或者不是null。在Java 8之前一般某个函数应该返回非空对象但是有时却什么也没有返回，而在Java 8中，你应该返回 Optional 而不是 null。
 * <p>
 * 示例中每个方法的作用已经添加。
 * Created by iQiwen on 2019/5/10.
 */
public class TestOptionals {
    public static void main(String[] args) {
        //of（）：为非null的值创建一个Optional
        Optional<String> optional = Optional.of("bam");
        // isPresent（）： 如果值存在返回true，否则返回false
        optional.isPresent();           // true
        //get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        optional.get();                 // "bam"
        //orElse（）：如果有值则将其返回，否则返回指定的其它值
        optional.orElse("fallback");    // "bam"
        //ifPresent（）：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
