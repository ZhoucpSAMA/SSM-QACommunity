package com.laozhou.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getFormatTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);

    }
}
