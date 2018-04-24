package com.graduate.laborManager.common.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class TimeUtil {
    public static String getNow14(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getNow8(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(System.currentTimeMillis());
    }

    public static String getFrontDay(int number){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -number);
        date = calendar.getTime();
        return dateFormat.format(date);
    }
}
