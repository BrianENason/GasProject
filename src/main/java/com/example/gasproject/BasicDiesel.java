package com.example.gasproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BasicDiesel {

    private LocalDate reportDate;
    private Double gallonPrice;

    public BasicDiesel(String reportDate, String gallonPrice) {
        setReportDate(reportDate);
        setGallonPrice(gallonPrice);
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(String rD) {
        LocalDate reportDate;

        // LocalDate reportDate2;

        String dateTogether = Conversions.convertToFullDate(rD);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd", Locale.ENGLISH);
        reportDate = LocalDate.parse(dateTogether, formatter);
        reportDate = Conversions.changeDay(reportDate);
        this.reportDate = reportDate;
        // reportDate2 = Conversions.changeDay(reportDate);
        // this.reportDate = reportDate2;
    }

    public Double getGallonPrice() {
        return gallonPrice;
    }

    public void setGallonPrice(String gP) {
        Double gallonPrice = Double.parseDouble(gP);
        this.gallonPrice = gallonPrice;
    }
}
