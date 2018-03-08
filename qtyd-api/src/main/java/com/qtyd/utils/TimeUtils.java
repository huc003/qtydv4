package com.qtyd.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//时间工具
public class TimeUtils {

    public static final long SECOND_DAY = 86400L;
    public static final long MILLISECOND_DAY = SECOND_DAY * 1000;

    public static final long MILLISECOND_8HOURS = 28800000L;
    public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmssInt = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String HHMMSS = "HHmmss";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";

    public static void main(String[] args) {
//		System.out.println(getYear(1484036290L));
//		System.out.println(getMonth(1484036290L));
//		Timestamp t = Timestamp.valueOf("2017-03-30 00:00:00.0");
//		System.out.println(t.toString());
//		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
//		System.out.println(sdf.format(t));
//		System.out.println(t.getTime());
//		System.out.println(t.getTime());
//		System.out.println(TimeUtils.getSecond(System.currentTimeMillis()));
//		System.out.println(TimeUtils.getMilliSecond(System.currentTimeMillis()));
//		System.out.println(TimeUtils.getSecond(System.currentTimeMillis()/1000));
//		System.out.println(TimeUtils.getMilliSecond(System.currentTimeMillis()/1000));

//		System.out.println(date(System.currentTimeMillis()/1000)) ;
//		System.out.println(date(System.currentTimeMillis())) ;
//		System.out.println(strDate(System.currentTimeMillis()/1000)) ;
//		System.out.println(strDay(System.currentTimeMillis()/1000)) ;
//		System.out.println(strTime(System.currentTimeMillis())) ;

        System.out.println(getLastMonthBegin());
        System.out.println(monthLastDay(2018,2));
    }

    /**
     * 返回时间戳对应的年月日（默认格式：2017-01-31）
     *
     * @return
     */
    public static String strDay() {
        return strDay(System.currentTimeMillis() / 1000);
    }

    /**
     * 返回时间戳对应的年月日（默认格式：2017-01-31）
     *
     * @param timestamp
     * @return
     */
    public static String strDay(long timestamp) {
        return str(timestamp, YYYY_MM_DD);
    }

    /**
     * 返回时间戳对应的时间（默认格式：14:00:59）
     *
     * @return
     */
    public static String strTime() {
        return strTime(System.currentTimeMillis() / 1000);
    }

    /**
     * 返回时间戳对应的时间（默认格式：14:00:59）
     *
     * @param timestamp
     * @return
     */
    public static String strTime(long timestamp) {
        return str(timestamp, HH_MM_SS);
    }

    /**
     * 返回时间戳对应的日期（默认格式：2017-01-31 14:00:59）
     *
     * @param timestamp
     * @return
     */
    public static String strDate(long timestamp) {
        return str(timestamp, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 返回时间戳对应日期格式的字符串
     *
     * @param timestamp 时间戳
     * @param format    日期格式
     * @return
     */
    public static String str(long timestamp, String format) {
        return str(date(timestamp), format);
    }

    /**
     * 返回格式化后的字符串
     *
     * @param date   日期
     * @param format 日期格式
     * @return
     */
    public static String str(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 时间戳转换成日期
     *
     * @param date   日期
     * @param format 日期格式
     * @return
     */
    public static Date date(long timestamp) {
        return new Date(getMilliSecond(timestamp));
    }


    public static Date gmtToDate(String time) {
        DateFormat formatFrom = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        Date serverDate = null;
        try {
            serverDate = formatFrom.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(serverDate);
        cal.add(Calendar.HOUR_OF_DAY, 8);
        return cal.getTime();
    }

    public static void sleep(long millis) {
        if (millis <= 0L) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return format.format(date);
    }

    public static Date parse(String data, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        try {
            return format.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化系统时间
     *
     * @param format
     * @return
     */
    private static String formatSysTime(SimpleDateFormat format) {
        String str = format.format(Calendar.getInstance().getTime());
        return str;
    }

    /**
     * 得到传入时间戳的年份
     *
     * @param timestamp
     * @return
     */
    public static int getYear(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        return cal.get(Calendar.YEAR);
    }

    /**
     * 得到传入时间戳的月份
     *
     * @param timestamp 时间戳
     * @return 月份 0-11
     */
    public static int getMonth(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        return cal.get(Calendar.MONTH);
    }

    public static String getSysTime() {
        return getSysTime(yyyyMMddHHmmss);
    }

    /**
     * 取得系统时间
     *
     * @param pattern eg:yyyy-MM-dd HH:mm:ss,SSS
     * @return
     */
    public static String getSysTime(String pattern) {
        return formatSysTime(new SimpleDateFormat(pattern));
    }

    public static String getSysTimeLong() {
        return getSysTime("yyyyMMddHHmmss");
    }

    public static long getPHPtime() {
        Date date = new Date();
        return date.getTime() / 1000;
    }

    /**
     * 获取今天零点的时间戳
     *
     * @return
     */
    public static long getCuFirstTime() {
        return loginAssignDayFirstTime(getSysTime(YYYY_MM_DD));
    }

    /**
     * 获取指定日期的零点时间戳
     *
     * @param day 日期格式字符串 yyyy-MM-dd
     * @return
     */
    public static long loginAssignDayFirstTime(String day) {
        Date date = parse(day + " 00:00:00", yyyyMMddHHmmss);
        return date.getTime() / 1000;
    }

    /**
     * 获取指定日期的23:59:59时间戳
     *
     * @param day 日期格式字符串 yyyy-MM-dd
     * @return
     */
    public static long loginAssignDayEndTime(String day) {
        Date date = parse(day + " 23:59:59", yyyyMMddHHmmss);
        return date.getTime() / 1000;
    }

    /**
     * 获取指定日期的前一天
     *
     * @param day     指定日期
     * @param pattern 日期格式化字符串
     * @return
     */
    public static String findBeforeDay(String day, String pattern) {
        return findDesignDay(parse(day, pattern), -1);
    }

    /**
     * 获取指定日期的前一天 零点 时间戳
     *
     * @param day 指定日期
     * @return
     */
    public static long beforeDayFirstTime(String day) {
        return loginAssignDayFirstTime(findBeforeDay(day, YYYY_MM_DD));
    }

    /**
     * 获取指定日期的前一天 23：59：59 时间戳
     *
     * @param day 指定日期
     * @return
     */
    public static long beforeDayEndTime(String day) {
        return loginAssignDayEndTime(findBeforeDay(day, YYYY_MM_DD));
    }

    /**
     * 获取前一天的格式化日期
     *
     * @param pattern 对应的格式字符串 如:yyyy-MM-dd
     * @return
     */
    public static String findBeforeDay(String pattern) {
        return findDesignDay(-1);
    }

    public static String getSysdateInt() {
        return getSysTime("yyyyMMdd");
    }

    public static String getSystimeInt() {
        return getSysTime("HHmmss");
    }

    public static String currentDate() {
        return getSysTime("yyyy-MM-dd");
    }

    public static String currentTime() {
        return getSysTime("HH:mm:ss");
    }

    public static long currentSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static Date format(String str, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date date = null;
        try {
            date = (Date) formatter.parse(str);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * 获得指定时间的时间戳
     *
     * @param data
     * @return
     */
    public static long getTimeStampByDate(String data, String pattern) {
        Date date = format(data, pattern);
        return date.getTime() / 1000;
    }

    public static long getTimeStampByDate(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 获得指定时间的时间戳
     *
     * @param data
     * @return
     */
    public static long getCurrentTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }


    public static long timeLimitDay(long startTime, long endTime) {
        Date date1 = new Date(startTime * 1000L);
        Date date2 = new Date(endTime * 1000L);
        return subtractDay(format(date2, "yyyyMMdd"), format(date1, "yyyyMMdd"), "yyyyMMdd");
    }

    /**
     * 得到今天的日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getSysdate() {
        return getSysTime("yyyy-MM-dd");
    }

    /**
     * 获取当月系统月份 年月
     *
     * @return
     */
    public static int getSysMonthInt() {

        return Integer.valueOf(getSysTime("yyyyMM") + "");
    }

    /**
     * 获取当月系统年份
     *
     * @return
     */
    public static int getSysYearInt() {

        return Integer.valueOf(getSysTime(YYYY));
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int getCurrMonthInt() {
        return Integer.valueOf(getSysTime(MM));
    }

    /**
     * 获取上月系统月份
     *
     * @return
     */
    public static int getLastMonthInt() {

        return Integer.valueOf(format(getLastMonthBegin(), "yyyyMM") + "");
    }


    /**
     * 把传入的时间戳转换成指定的时间格式
     *
     * @param timeStamp
     * @param pattern
     * @return
     */
    public static String format(Long timeStamp, String pattern) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        String str = format.format(date);

        return str;
    }

    /**
     * 在给定的时间上加上指定的月
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, int month) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 得到昨天的这个时候
     *
     * @return
     */
    public static Date getYesterday() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 得到上个月的这个时候
     *
     * @return
     */
    public static Date getLastmonth() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    /**
     * 得到去年的这个时候
     *
     * @return
     */
    public static Date getLastyear() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }

    /**
     * 在当前时间添加指定的天数 Date类型
     *
     * @param days
     * @return
     */
    public static Date getDate(int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 在当前时间上加上指定的天数  yyyy-MM-dd HH:mm:ss
     *
     * @param days
     * @return
     */
    public static String getDateEnd(int days) {
        Date date = TimeUtils.format(getSysdateTimeEnd(), yyyyMMddHHmmss);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date date2 = cal.getTime();
        return format(date2, yyyyMMddHHmmss);
    }

    /**
     * 在传入的时间上加上指定的天数 Date
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDate(Date date, int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    public static Date getDateBySecond(Date date, int second) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }

    public static Date getHour(int hours) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }

    /**
     * 得到今天开始的时间 yyyy-MM-dd 00:00:00
     *
     * @return
     */
    public static String getSysdateTimeStart() {
        return getSysdate() + " 00:00:00";
    }

    /**
     * 得到今天的最后一秒 yyyy-MM-dd 23:59:59
     *
     * @return
     */
    public static String getSysdateTimeEnd() {
        return getSysdate() + " 23:59:59";
    }

    /**
     * 得到某个时间戳所在的日期（天）的第一秒
     *
     * @param timestamp 某个时间戳
     * @return 返回13位时间戳
     */
    public static final long getDayTimeBegin(long timestamp) {
        return (getMilliSecond(timestamp) + MILLISECOND_8HOURS) / MILLISECOND_DAY * MILLISECOND_DAY - MILLISECOND_8HOURS;
    }

    /**
     * 将时间戳转换为单位是秒的时间戳
     *
     * @param timestamp 某个时间戳
     * @return 返回10位时间戳
     */
    public static final long getSecond(long timestamp) {
        if (timestamp > 9999999999l) {
            timestamp = timestamp / 1000;
        }
        return timestamp;
    }

    /**
     * 将时间戳转换为单位是秒的时间戳
     *
     * @param timestamp 某个时间戳
     * @return 返回13位时间戳
     */
    public static final long getMilliSecond(long timestamp) {
        if (timestamp < 9999999999l) {
            timestamp = timestamp * 1000;
        }
        return timestamp;
    }

    /**
     * 得到某个时间戳所在的日期（天）的最后一秒
     *
     * @param timestamp 某个时间戳
     * @return 返回13位时间戳
     */
    public static final long getDayTimeEnd(long timestamp) {
        return getDayTimeBegin(timestamp) + MILLISECOND_DAY - 1000;
    }

    /**
     * 在指定的时间戳上增加days天
     *
     * @param timestamp 时间戳
     * @param days      增加的天数
     * @return 返回13位时间戳
     */
    public static final long addDays(long timestamp, int days) {
        return getMilliSecond(timestamp) + days * MILLISECOND_DAY;
    }

    /**
     * 获取指定时间段之内经过的天数
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static int getDays(long beginTime, long endTime) {
        return (int) ((getDayTimeBegin(endTime) - getDayTimeBegin(beginTime)) / MILLISECOND_DAY) + 1;
    }


    public static long subtract(String end, String start, String pattern) {
        return format(end, pattern).getTime() - format(start, pattern).getTime();
    }

    public static long subtractDay(String end, String start, String pattern) {
        return subtract(end, start, pattern) / MILLISECOND_DAY;
    }

    public static long addDay(long oldTime, int day) {
        Date date = new Date(oldTime * 1000l);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTimeInMillis() / 1000;
    }

    public static long subtractLong(String start) {
        return subtract(getSysTimeLong(), start, "yyyyMMddHHmmss");
    }


    /**
     * 查询今天之前指定天数的时间 格式 YYYY-MM-DD
     *
     * @param days 指定天数 -30 表示往前推30天 30表示往后推30天
     * @return
     */
    public static String findDesignDay(int days) {
        return findDesignDay(new Date(), days);
    }

    /**
     * 查询指定日期之前指定天数的时间 格式 YYYY-MM-DD
     *
     * @param days 指定天数 -30 表示往前推30天 30表示往后推30天
     * @return
     */
    public static String findDesignDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return format(calendar.getTime(), YYYY_MM_DD);
    }

    /**
     * 查询今天之前指定天数的时间 格式 YYYY-MM-DD
     *
     * @param days    指定天数 -30 表示往前推30天 30表示往后推30天
     * @param is_have 是否包含今天
     * @return
     */
    public static String findDesignDay(int days, boolean is_have) {
        if (is_have) days = days - 1;
        return findDesignDay(days);
    }

    /**
     * 获取每月的第一天
     *
     * @return
     */
    public static Long monthFirstDay() {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取每月的最后一天
     *
     * @return
     */
    public static Long monthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取指定月份的第一天零点时间戳
     *
     * @param year  年份
     * @param month 传入的月份 1-12
     * @return
     */
    public static Long monthFirstDay(int year, int month) {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取指定月份的最后一天时间戳
     *
     * @param year  年份
     * @param month 月份 1-12
     * @return
     */
    public static Long monthLastDay(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, 1); //把日期设置为当月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.MILLISECOND, 0);
        calendar.roll(Calendar.DATE, -1); //日期回滚一天，也就是最后一天
        return calendar.getTime().getTime() / 1000;
//        calendar.set(Calendar.MONTH, month - 1);
//        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.SECOND, 59);
//        calendar.set(Calendar.MINUTE, 59);
//        calendar.set(Calendar.MILLISECOND, 0);
//        return calendar.getTime().getTime() / 1000;
    }

    /***
     * 获取几天前的时间戳
     * @param day
     * @return
     */
    public static long settingDay(int day) {
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.add(Calendar.DATE, -day);
        return cal.getTime().getTime() / 1000;
    }

    /****
     * 获取当天的零点时间
     * @return
     */
    public static long getDayStarttamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    /***
     * 获取当天结束时间23：59
     * @return
     */
    public static long getDayEndtamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * @return long
     * @Description: 获取当月最后一天
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getMonthEndTamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * @return long
     * @Description: 获取当月最后一天的零点时间
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getMonthEndDayStartTamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * @return long
     * @Description: 获取当月第一天
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getMonthStartTamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }


    /**
     * @return long
     * @Description: 获取当月最后一天的零点时间
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getMonthStartDayEndTamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }


    /**
     * @return long
     * @Description: 获取前一天零点
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getBeforeDayStartTamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * @return long
     * @Description: 获取前一天结束
     * @author huangwt
     * @date 2017年9月13日
     */
    public static long getBeforeDayEndTamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取上个月的第一天
     *
     * @return
     */
    public static Long getLastMonthBegin() {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取上个月的最后一天
     *
     * @return
     */
    public static Long getLastMonthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

}
