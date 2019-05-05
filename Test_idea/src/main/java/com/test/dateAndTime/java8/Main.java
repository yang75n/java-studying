package com.test.dateAndTime.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * Created by iQiwen on 2019/5/5.
 */
public class Main {
    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    @Test
    public void testLocalDateAndLocalTime() {
        //1.1 通过of重载的工厂方法创建

        LocalDate ofDate = LocalDate.of(2014, 3, 18);//2014-03-18

        LocalTime ofTime = LocalTime.of(13, 45, 20); // 13:45:20

        //1.2 使用静态方法parse来创建

        LocalDate parseDate = LocalDate.parse("2014-03-18");//2014-03-18

        LocalTime parseTime = LocalTime.parse("13:45:20");// 13:45:20


        //3. 创建LocalDateTime的两种方式

        //3.1 通过重载的of工厂方法创建

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println(dt1);

        LocalDateTime dt2 = LocalDateTime.of(ofDate, ofTime);
        System.out.println(dt2);

        //3.2 通过合并日期和时间的方式创建

        LocalDateTime dt3 = ofDate.atTime(13, 45, 20);

        LocalDateTime dt4 = ofDate.atTime(ofTime);

        LocalDateTime dt5 = ofTime.atDate(ofDate);

        //4. 从LocalDateTime中提取LocalDate或者LocalTime 组件

        LocalDate date1 = dt1.toLocalDate();//2014-03-18

        LocalTime time1 = dt1.toLocalTime();//13:45:20


    }

    @Test
    public void testDateTimeFormatter() {
        LocalDate date = LocalDate.of(2014, 3, 18);

        //1. 从时间生成字符串

        //1.1 使用特定不同的格式器生成字符串

        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318

        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18


        //1.2 DateTimeFormatter类还支持静态工厂方法，它可以按 照某个特定的模式创建格式器

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter chinaFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);


        String s3 = date.format(formatter);//18/03/2014
        System.out.println(s3);

        String s5 = date.format(chinaFormatter2);//2014年3月18日 星期二
        System.out.println(s5);

        //2. 从字符串生成时间

        //2.1 通过解析代表日期或时间的字符串重新创建该日期对象。

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);

        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date3 = LocalDate.parse("18/03/2014", formatter);

        LocalDate date5 = LocalDate.parse("2014年3月18日 星期二", chinaFormatter2);
        System.out.printf("date5=%s\n", date5);

        //3. 自定义DateTimeFormatter

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()

                .appendText(ChronoField.DAY_OF_MONTH)

                .appendLiteral(". ")

                .appendText(ChronoField.MONTH_OF_YEAR)

                .appendLiteral(" ")

                .appendText(ChronoField.YEAR)

                .parseCaseInsensitive()

                .toFormatter(Locale.ITALIAN);

    }
}
