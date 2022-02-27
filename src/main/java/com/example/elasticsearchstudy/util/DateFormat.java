package com.example.elasticsearchstudy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LING lbh19970425@gmail.com
 * @date 2022/2/27 11:22
 */
public class DateFormat {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String format(Date date){
        return DateFormat.format.format(date);
    }
}
