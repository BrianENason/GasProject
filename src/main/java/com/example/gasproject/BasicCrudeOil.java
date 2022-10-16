package com.example.gasproject;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BasicCrudeOil {


    private static final DecimalFormat df = new DecimalFormat("0.00");

    private LocalDate reportDate;
    private Double barrelPrice;
    private Double gallonPrice;
    private Integer barrelSize = 44;

    public BasicCrudeOil(String reportDate, String barrelPrice, String gallonPrice) {
        setReportDate(reportDate);
        setBarrelPrice(barrelPrice);
        setBarrelSize(barrelSize);
        setGallonPrice(gallonPrice);
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        LocalDate date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        date = LocalDate.parse(reportDate, formatter);
        this.reportDate = date;
    }

    public Double getBarrelPrice() {
        return barrelPrice;
    }

    public void setBarrelPrice(String bP) {
        Double barrelPrice = Double.parseDouble(bP);
        df.format(barrelPrice);
        this.barrelPrice = barrelPrice;
    }

    public Integer getBarrelSize() {
        return barrelSize;
    }

    public void setBarrelSize(Integer barrelSize) {
        this.barrelSize = barrelSize;
    }

    public Double getGallonPrice() {
        return gallonPrice;
    }

    public void setGallonPrice(String gP) {
        Double gallonPrice = Double.parseDouble(gP);
        this.gallonPrice = gallonPrice;
    }

}
