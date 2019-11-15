package com.var.utils;

import java.beans.BeanInfo;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VarUtils {

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public static Date parseDateYYYYMMDD(String nonParsedDate) {
        Date parsedDate = null;
        // Create SimpleDateFormat object
        SimpleDateFormat sdfo  = new SimpleDateFormat("yyyy-MM-dd");

        try {
            parsedDate = sdfo.parse(nonParsedDate);
        } catch (ParseException e) {
            System.err.println("non parsed Date : " + nonParsedDate );
        }

        return parsedDate;
    }

    public static int findTheNthPercentile(int numberOfData, int percentile){
        return (int)((numberOfData * percentile)/100) ;
    }

    public static BigDecimal parseCurrency(String value) {

        NumberFormat fmt = NumberFormat.getNumberInstance(Locale.FRANCE);
        ((DecimalFormat)fmt).setParseBigDecimal(true);
        try {
            return (BigDecimal)fmt.parse(value);
        } catch (Exception e){
            System.err.println("Erreur in parsing the amount  : " + value );
            return new BigDecimal(0);
        }

    }

    public static Date getXdaysBefore(Date in, int days) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(in);
        calendar.add(Calendar.DATE, - days);
        return calendar.getTime();
    }
}
