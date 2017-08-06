package com.zkx.bbs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zkx on 2017/5/5.
 */
public class DateUtil {
    public static final String HENGXIAN_DATE_MAOHAO_TIME_24 = "yyyy-MM-dd HH:mm";
    public static final String XIEXIAN_DATE_MAOHAO_TIME_24 = "yyyy/MM/dd HH:mm";
    public static final String DIAN_DATE_MAOHAO_TIME_24 = "MM.dd HH:mm";
    public static final String DIAN_YEAR_DATE_MAOHAO_TIME_24 = "yy.MM.dd HH:mm";
    public static final String HANZI_YEAR_DATE_MAOHAO_TIME_24 = "yyyy年M月d日 HH:mm";
    public static final String HANZI_DATE_MAOHAO_TIME_24 = "M月d日 HH:mm";
    public static final String HANZI_YEAR_0DATE_MAOHAO_TIME_24 = "yyyy年MM月dd日 HH:mm";
    public static final String HANZI_0DATE_MAOHAO_TIME_24 = "MM月dd日 HH:mm";


    public static String formatTime(String pattern, String patternOtherYear, Long timeStamp) {
        if (timeStamp == null || timeStamp == 0) return "";
        boolean isSameYear = isSameYear(timeStamp, Calendar.getInstance());
        if (isSameYear) {
            return formatTime(timeStamp, pattern);
        } else {
            return formatTime(timeStamp, patternOtherYear);
        }
    }

    public static String formatTime(Long timeStamp, String pattern) {
        if (timeStamp == null || timeStamp == 0) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(timeStamp * 1000L));
    }

    private static boolean isSameYear(Long time1, Long time2) {
        Calendar calendar2 = Calendar.getInstance();
        time2 = Long.valueOf(time2.longValue() * 1000L);
        calendar2.setTimeInMillis(time2.longValue());
        return isSameYear(time1, calendar2);
    }

    private static boolean isSameYear(Long time1, Calendar calendar2) {
        time1 = Long.valueOf(time1.longValue() * 1000L);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(time1.longValue());

        return isSameYear(calendar1, calendar2);
    }

    private static boolean isSameYear(Calendar calendar1, Calendar calendar2) {
        int year1 = calendar1.get(1);
        int year2 = calendar2.get(1);
        return year2 == year1;
    }

    public static boolean isInCurMonth(Long targetTime) {
        if (targetTime == null || targetTime == 0) return false;
        Calendar calendar = Calendar.getInstance();
        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        calendar.setTimeInMillis(targetTime * 1000L);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        if (curYear == year && curMonth == month) {
            return true;
        }
        return false;
    }
}
