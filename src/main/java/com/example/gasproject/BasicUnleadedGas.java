package com.example.gasproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BasicUnleadedGas {

    private LocalDate reportDate;
    private Double gallonPrice;

    public BasicUnleadedGas(String reportDate, String gallonPrice) {
        setReportDate(reportDate);
        setGallonPrice(gallonPrice);
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(String rD) {
        LocalDate reportDate;  // Variable to hold the converted LocalDate object
        String dateTogether = Conversions.convertToFullDate(rD);  // This adds a "Day" to the parsed data.

        // Convert the new String date reference into a Date object of specific format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd", Locale.ENGLISH);
        reportDate = LocalDate.parse(dateTogether, formatter);

        // Finds the "Last Day" of the month and sets that as the "Day"
        reportDate = Conversions.changeDay(reportDate);

        // Return the new date to the "UnleadedGas" object
        this.reportDate = reportDate;
    }

    public Double getGallonPrice() {
        return gallonPrice;
    }

    public void setGallonPrice(String gP) {
        Double gallonPrice = Double.parseDouble(gP);
        this.gallonPrice = gallonPrice;
    }
}

/*

    public void setReportDate(String rD) {
        LocalDate reportDate;
        String dateTogether = Conversions.convertDate(rD);

        String year = rD.substring(0, 4);
        String month = rD.substring(5, 8);
        String day = "01";
        String dateTogether = (year + "-" + month + "-" + day);
        System.out.println(dateTogether);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd", Locale.ENGLISH);
        reportDate = LocalDate.parse(dateTogether, formatter);
        this.reportDate = reportDate;
    }*/
