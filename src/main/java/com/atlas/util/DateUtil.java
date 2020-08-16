package com.atlas.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * Created by Mayukh on 8/4/2019.
 */
public class DateUtil {
    public static Long DEFAULT_OFFSET = -330L * 60 * 1000;
    public static Long DEFAULT_OFFSET1 = -330L * 60 * 1000;
    public static Long DEFAULT_OFFSET2 = 330L * 60 * 1000;

    public static long getDateMidNight(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }


    public static long getNextDateMidNight(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date - DEFAULT_OFFSET1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }

    public static long getNextUTCDateMidNight(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }

    public static long getScheduleDateMidNight(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date - DEFAULT_OFFSET1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }


    public static long getNextScheduleDateMidNight(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date - DEFAULT_OFFSET1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }


    public static long getDateTimeByLong(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }

    public static long getDateTimeByLongAdd(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        return cal.getTimeInMillis() - DEFAULT_OFFSET1;
    }

    public static long getClientCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis() - DEFAULT_OFFSET1;
    }

    public static long getCurrentMidNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis() + DEFAULT_OFFSET1;
    }

    public static long getDateTime(String dateTime) {
        long time = 0;
        try {
            System.out.println(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            Date date = formatter.parse(dateTime);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date.getTime());
            time = cal.getTimeInMillis();
            System.out.println(time);
            System.out.println(date);
        } catch (Exception e) {
            time = 0;
        }
        return time + DEFAULT_OFFSET;
    }


    public static int getDifferenceDays(long startDate, long endDate) {
        Date shiftStart = new Date();
        Date shiftEnd = new Date();
        shiftStart.setTime(startDate);
        shiftEnd.setTime(endDate);
        int diffInDays = (int) ((shiftStart.getTime() - shiftEnd.getTime())
                / (1000 * 60 * 60 * 24));
        return diffInDays;
    }


    public static long getMinuteDifference(long startTime, long endTime) {
        Date shiftStart = new Date();
        Date shiftEnd = new Date();
        shiftStart.setTime(startTime);
        shiftEnd.setTime(endTime);
        int diffInMinutes = (int) ((shiftStart.getTime() - shiftEnd.getTime())
                / (1000 * 60));
        return diffInMinutes;
    }

    /**
     * To truncate the "." from the Zip.
     *
     * @param value
     * @return
     */
	/*
	 * public static String truncateByDot(String value) { if (value != null &&
	 * !Constants.STRING_BLANK.equals(value)) { value = value.split("\\.")[0]; }
	 * return value; }
	 */

    public static long getUpdatedDateTime(long newDate, long oldDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(newDate);

        Calendar updatedCalendar = Calendar.getInstance();
        updatedCalendar.setTimeInMillis(oldDate);
        updatedCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        return updatedCalendar.getTimeInMillis();
    }

    public static String getTime(long dateTime) {
        dateTime = dateTime + DEFAULT_OFFSET2;
        String dateTimeString = "";
        try {
            System.out.println(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dateTime);
            dateTimeString = formatter.format(cal.getTime());
        } catch (Exception e) {
            dateTimeString = "";
        }
        return dateTimeString;
    }

    public static boolean overlapDateCheck(Long start1, Long end1, Long start2, Long end2) {
        if ((start1 >= start2 && start1 <= end2) || (end1 >= start2 && end1 <= end2)) {
            return true;
        } else if ((start2 >= start1 && start2 <= end1) || (end2 >= start1 && end2 <= end1)) {
            return true;
        }
        return false;
    }


    /**
     * @return
     */
    public static Calendar getISTCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        return cal;
    }

    public static String getFormattedDateTime(long dateTime) {
        String dateTimeString = "";
        try {
            System.out.println(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dateTime);
            dateTimeString = formatter.format(cal.getTime());
        } catch (Exception e) {
            dateTimeString = "";
        }
        return dateTimeString;
    }

    public static String getFormattedRevaDateTime(long dateTime) {
        String dateTimeString = "";
        try {
            System.out.println(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dateTime);
            dateTimeString = formatter.format(cal.getTime());
        } catch (Exception e) {
            dateTimeString = "";
        }
        return dateTimeString;
    }

    public static long getRevaDateTime(String dateTime) {
        long time = 0;
        try {
            System.out.println(dateTime);
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = formatter.parse(dateTime);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date.getTime());
            time = cal.getTimeInMillis();
            System.out.println(time);
            System.out.println(date);
        } catch (Exception e) {
            time = 0;
        }
        return time + DEFAULT_OFFSET;
    }

}
