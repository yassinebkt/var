package com.var.domaine;

import java.util.Date;

public class InputData {
    private Date currentDate ;
    private int historicalDept;
    private int percentileCoefficient;
    private String csvPath;

    @Override
    public String toString() {
        return "InputData{" +
                "currentDate=" + currentDate +
                ", historicalDept=" + historicalDept +
                ", percentileCoefficient=" + percentileCoefficient +
                ", csvPath='" + csvPath + '\'' +
                '}';
    }

    public InputData() { }

    public InputData(Date currentDate, int historicalDept, int percentileCoefficient, String csvPath) {
        this.currentDate = currentDate;
        this.historicalDept = historicalDept;
        this.percentileCoefficient = percentileCoefficient;
        this.csvPath = csvPath;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public int getHistoricalDept() {
        return historicalDept;
    }

    public void setHistoricalDept(int historicalDept) {
        this.historicalDept = historicalDept;
    }

    public int getPercentileCoefficient() {
        return percentileCoefficient;
    }

    public void setPercentileCoefficient(int percentileCoefficient) {
        this.percentileCoefficient = percentileCoefficient;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }
}
