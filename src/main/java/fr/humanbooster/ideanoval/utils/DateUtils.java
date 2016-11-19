package fr.humanbooster.ideanoval.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nea on 05/11/2016.
 */
public class DateUtils {

    /**
     * Convertit une date java.util.date en sql.date
     * @param dateUtil date à convertir
     * @return sql.date
     */
    public java.sql.Date convertUtilDateToSqlDate(Date dateUtil) {
        return new java.sql.Date(dateUtil.getTime());
    }

    /**
     * Convertit une sql.date en java.util.date
     * @param sqlDate date à convertir
     * @return java.util.date
     */
    public Date convertSqlDateToUtilDate(java.sql.Date sqlDate) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(sqlDate.getTime());
        return c.getTime();
    }

    /**
     * Convertir String en java.util.date
     * @param date String qui contient une date formattée pour une localisation française
     * @return java.util.date
     */
    public Date getDateFromString(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = new Date();
        try {
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }

    public static String getStringFromDate(Date date) {
        DateFormat formatDateJava = new SimpleDateFormat("dd-MM-yyyy");
        return formatDateJava.format(date);
    }
}
