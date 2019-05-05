package com.test.dateAndTime;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by iQiwen on 2019/5/5.
 */
public class Main {
    @Test
    public void testcurrentTimeMillis() {
        long time = System.currentTimeMillis();
        System.out.printf("currentTime=%s\n", time);

    }

    @Test
    public void testTimeUnit() {
        //1天有24个小时    1代表1天：将1天转化为小时
        System.out.println(TimeUnit.DAYS.toHours(1));
        //结果： 24


        //1小时有3600秒
        System.out.println(TimeUnit.HOURS.toSeconds(1));
        //结果3600


        //把3天转化成小时
        System.out.println(TimeUnit.HOURS.convert(3, TimeUnit.DAYS));
        //结果是：72


    }

    @Test
    public void testDate() {
        Date date = new Date();
        System.out.printf("date=%s\n", date);
        System.out.printf("当前日期换成毫秒数:%s\n", date.getTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(date);
        System.out.printf("格式化后日期:%s\n", dateStr);

    }

    /**
     * A.Calendar的星期是从周日开始的，常量值为1。
     * B.Calendar的月份是从一月开始的，常量值为0。
     */
    @Test
    public void testCalendar() {
        Calendar now = Calendar.getInstance(); //默认为当前时间
        System.out.println(now.getTime());
        now.setTimeZone(TimeZone.getTimeZone("GMT+8:00")); //设置时区 北京时间
        //now.set(2016, 10, 30, 15, 55, 44); //陷阱:Calendar的月份是0~11
        Calendar now2 = new GregorianCalendar(); //默认为当前时间
        Calendar now3 = new GregorianCalendar(2016, 10, 30, 15, 55, 44); //陷阱:Calendar的月份是0~11


        System.out.println("年: " + now.get(Calendar.YEAR)); //返回int类型
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1)); //返回int类型，注意：月份从零开始
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH)); //返回int类型
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY)); //返回int类型
        System.out.println("分: " + now.get(Calendar.MINUTE)); //返回int类型
        System.out.println("秒: " + now.get(Calendar.SECOND)); //返回int类型
        System.out.println("Date类型日期：" + now.getTime()); //返回Date类型
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis()); //返回long类型
    }
}
