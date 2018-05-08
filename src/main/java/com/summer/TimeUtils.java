package com.summer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtils {
    public static void main(String[] args) {
        System.out.println();
    }
    private static String pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间转时间戳
     * 时间格式1 2018-04-21
     * 时间格式2 2018-04-21 16:11
     * 时间格式3 2018-04-21 16:11:30
     * 时间格式4 16:11              不指定日期默认值为当天日期,16:11 指当天的16:11:00的时间戳s
     * 时间格式5 16:11:30
     *
     * @param time 时间
     */
    public static long time2Long(String time) throws ParseException {
        time = time.replace("/", "-");
        String formatStr = "yyyy-MM-dd";
        if (!time.contains("-")) {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            time = date + " " + time;
        }
        int timeModel = time.split(":").length;
        if (timeModel == 2) {
            formatStr = "yyyy-MM-dd HH:mm";
        } else if (timeModel == 3) {
            formatStr = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.parse(time).getTime() / 1000;
    }


    /**
     * 获取相对今天偏移n天的开始时间戳
     *
     * @param offset 向后偏移几天 1明天 -1 昨天
     * @return 当天的时间戳(s)
     */
    public static long dayStartTimestamp(int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static String longToStr(Long time, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return time != null ? format.format(time * 1000) : null;
    }

    public static String nowToStr(String pattern) {
        return longToStr(System.currentTimeMillis() / 1000, pattern);
    }

}
