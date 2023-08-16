package com.example.intelligentscheduling;

import com.example.intelligentscheduling.dao.TokenUtil;
import com.example.intelligentscheduling.entity.Employee;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();//获得一个日历
        Date datet;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;//指示一个星期中的某天。
        if (w< 0)
            w = 0;
        return weekDays[w];
    }
    public static String getWeek(Date datetime){
        SimpleDateFormat sdf = new SimpleDateFormat( "EEEE");
        return sdf.format(datetime);
    }
     /**
     * 获取过去7天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> getDays(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = intervals -1; i >= 0; i--) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }
    /**
     * 获取过去第几天的日期
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }
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

    public static void main(String[] args) throws Exception {

//        System.out.println(dateToWeek("2023-1-26"));
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        Date date=f.parse("2023-1-28");
//        System.out.println(getWeek(date));
//        List<String> list=getDays(10);
//        System.out.println(getDays(10).get(0));

//        List<String> array=getTimeInterval(new Date());
//        List<String> array=getLastTimeInterval();//获取本周时间
//        String start_time= array.get(0);//本周第一天
//        String end_time= array.get(1);  //本周最后一天
//        //格式化日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        List<String> lDate = findDates(start_time, end_time);//获取这周所有date
//        for (String date : lDate)
//        {
//            System.out.println(date);
//        }


//        GregorianCalendar calendar = new GregorianCalendar();
//        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
//        Date date=f.parse("13:12:30");
//        calendar.setTime(date);
//        //获取小时
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        //获取分钟
//        int minutes=calendar.get(Calendar.MINUTE);
//        //获取秒数
//        int seconds=calendar.get(Calendar.SECOND);
//        System.out.println(hour+"   "+minutes+"   "+seconds);

//        GregorianCalendar calendar = new GregorianCalendar();
//        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
//        String startTime="8:00";
//        Date time=f.parse(startTime);
//        String Time=f.format(time);
//        for (int i=0;i<5;i++) {
//            System.out.println(Time);
//            calendar.setTime(time);
//            calendar.add(Calendar.HOUR_OF_DAY,1);
//            time=calendar.getTime();
//            Time=f.format(time);
//        }


//        GregorianCalendar calendar = new GregorianCalendar();
//        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
//        Date nextTime=f.parse("22:00");
//        calendar.setTime(nextTime);
//        calendar.add(Calendar.HOUR_OF_DAY,3);
//        String endTime=f.format(calendar.getTime());
//        System.out.println(endTime);


        Employee employee=new Employee();
        employee.setEmployeeName("张三");
        String token= TokenUtil.sign(employee);
        System.out.println(token);
        TokenUtil.verify(token);
    }

//    //time to String
//    String string = DateFormat.getDateTimeInstance().format(date);
//    //String to time
//    Date = DateFormat.getDateTimeInstance().parse(time);
}


