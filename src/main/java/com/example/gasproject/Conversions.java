package com.example.gasproject;

import java.io.LineNumberInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conversions {

    /**
     * Two of the data sets have their Date Identifiers as "yyyy Jan" (or Feb, etc.).
     *
     * This method will parse this string, pull out the "Year" and the "Month", add in "01" for the date,
     * format the string to match the one dataset that has the YEAR-MONTH-DAY, and then return the string
     * for further processing by the calling method if needed.
     *
     * @param date
     * @return
     */
    public static String convertToFullDate(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 8);
        String day = "01";
        String completeDate = (year + "-" + month + "-" + day);
        return completeDate;
    }

    /**
     * This method will take in the date that it is passed and change the "Day" of the week to the last day of the
     * month. This way the data is standardized as 2 of the 3 data sets only reported the "Month" and "Year", and it
     * is assumed that the "Date" was supposed to be the end of the month.
     *
     * @param date
     * @return dateChanged
     */
    public static LocalDate changeDay(LocalDate date) {
        LocalDate dateChanged = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));

        // FIXME: For debugging Only. Delete from final product
        // System.out.println("This date has been changed to " + dateChanged);

        return dateChanged;
    }

    /**
     * This will take in a date object and extract the month and the year, and then return them as a string
     * object.
     *
     * FIXME: This is mostly used for debug purposes only
     * @param date
     * @return
     */
    public static String extractMonthAndYear(LocalDate date) {
        DateTimeFormatter yearMonth = DateTimeFormatter.ofPattern("MM-yyyy");
        String extractedDate = date.format(yearMonth);
        return extractedDate;
    }

}
