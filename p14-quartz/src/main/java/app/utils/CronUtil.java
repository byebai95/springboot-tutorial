package app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: bai
 * @Date: 2021/12/6 10:52
 */
public class CronUtil {

    public static String formatDateByPattern(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    public static String getCron(Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    public static void main(String[] args) {
        System.out.println(getCron(new Date()));
    }
}
