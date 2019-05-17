package com.test.dateAndTime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by iQiwen on 2019/5/5.
 */
public class Main_java8 {

    /**
     * LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 173015。
     * 下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差：
     */
    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime now1 = LocalTime.now(ZoneId.of("Europe/Berlin"));
        LocalTime now2 = LocalTime.now(ZoneId.of("Brazil/East"));
        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239
    }

    /**
     * LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 173015。
     * 下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差：
     */
    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    /**
     * Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，
     * 可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
     * 某一个特定的时间点也可以使用 Instant 类来表示，
     * Instant 类也可以用来创建旧版本的java.util.Date 对象。
     */
    @Test
    public void testClock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1552379579043
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant); //2019-03-12T08:46:42.588Z
        System.out.println(legacyDate);//Tue Mar 12 16:32:59 CST 2019
    }

    /**
     * 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。
     * 抽象类ZoneId（在java.time包中）表示一个区域标识符。
     * 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域标识符。
     */
    @Test
    public void testTimezones() {
        //输出所有区域标识符
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());// ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules());// ZoneRules[currentStandardOffset=-03:00]
    }

    /**
     * LocalDateTime 同时表示了时间和日期，相当于前两节内容合并到一个对象上了。
     * LocalDateTime 和 LocalTime还有 LocalDate 一样，都是不可变的。LocalDateTime 提供了一些能访问具体字段的方法。
     */

    @Test
    public void testLocalDateTime() {
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
