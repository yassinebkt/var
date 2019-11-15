package com.var.domaine;

import java.util.Date;
import java.util.Objects;

public class CSVData implements Comparable<CSVData> {

    private Date period;
    private Double pAndL;


    public CSVData(Date period, Double pAndL) {
        this.period = period;
        this.pAndL = pAndL;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Double getpAndL() {
        return pAndL;
    }

    public void setpAndL(Double pAndL) {
        this.pAndL = pAndL;
    }

    public int compareTo(CSVData csvData) {
        return (int)(csvData.getpAndL() - this.getpAndL());
    }

    @Override
    public String toString() {
        return "CSVData{" +
                "period=" + period +
                ", pAndL=" + pAndL +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSVData csvData = (CSVData) o;
        return Objects.equals(period, csvData.period) &&
                Objects.equals(pAndL, csvData.pAndL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, pAndL);
    }
}
