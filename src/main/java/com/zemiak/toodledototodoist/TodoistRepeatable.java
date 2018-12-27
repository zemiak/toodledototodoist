package com.zemiak.toodledototodoist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodoistRepeatable {
    private static final String[] DAYS = new String[]{"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};

    public static String get(String textDate, String repeat) {
        Date date = getDate(textDate);
        if (null == date) {
            return "";
        }

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);

        String day = DAYS[instance.get(Calendar.DAY_OF_WEEK) - 1];
        if ("daily".equals(repeat)) {
            return "daily";
        }

        if ("weekly".equals(repeat)) {
            return "every " + day;
        }

        if ("monthly".equals(repeat)) {
            int d = instance.get(Calendar.DAY_OF_MONTH);
            return "every " + d + getNumberSuffix(d);
        }

        if ("semiannually".equals(repeat)) {
            return "every six months";
        }

        return repeat;
    }

    private static String getNumberSuffix(int num) {
        if (Math.abs(num) == 1) {
            return "st";
        }

        if (Math.abs(num) == 2) {
            return "nd";
        }

        if (Math.abs(num) == 3) {
            return "rd";
        }

        return "th";
    }

    private static Date getDate(String textDate) {
        // from ISO string 2018-12-20 to day of week: monday, tuesday, ...
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date;
        try {
            date = simpleDateFormat.parse(textDate);
        } catch (ParseException ex) {
            return null;
        }

        return date;
    }
}
