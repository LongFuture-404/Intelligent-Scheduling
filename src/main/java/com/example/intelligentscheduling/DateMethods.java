package com.example.intelligentscheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateMethods {
    public static List<String> getTimeInterval(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + imptimeEnd);
        List<String> weekDate=new ArrayList<>();
        weekDate.add(imptimeBegin);
        weekDate.add(imptimeEnd);
        return weekDate;
    }
    public static List<String> getLastTimeInterval() {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        calendar2.add(Calendar.DATE, offset2 - 7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(sdf.format(calendar1.getTime()));// last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
        // System.out.println(sdf.format(calendar2.getTime()));// last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        List<String> weekDate=new ArrayList<>();
        weekDate.add(lastBeginDate);
        weekDate.add(lastEndDate);
        return weekDate;
    }
    public static List<String> findDates(String dBegin, String dEnd) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lDate = new ArrayList<String>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime( sdf.parse(dBegin));
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(sdf.parse(dEnd));
        // 测试此日期是否在指定日期之后
        while (sdf.parse(dEnd).after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sdf.format(calBegin.getTime()));
        }
        return lDate;
    }
    public static String getEndTime(String startTime,String type,Integer workTime) throws ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date nextTime=f.parse(startTime);
        calendar.setTime(nextTime);
        if (type.equals("hour")){
            calendar.add(Calendar.HOUR,workTime);
        }
        if (type.equals("minutes")){
            calendar.add(Calendar.MINUTE,workTime);
        }
        return f.format(calendar.getTime());
    }
}
