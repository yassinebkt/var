package com.var.services;

import com.var.domaine.CSVData;
import com.var.domaine.InputData;
import com.var.utils.VarUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class VarService {

    public double  getTheVarForACertainPercentile(List<CSVData> csvData, InputData inputData) {
        // Sorting P&L
        Collections.sort(csvData);

        // Getting the Var
        double theVar = 0;
        int theNthPercentile = VarUtils.findTheNthPercentile(csvData.size(), inputData.getPercentileCoefficient());
        if (csvData.size() > 0){
            if (csvData.get(theNthPercentile - 1) != null){
                theVar = csvData.get(theNthPercentile - 1).getpAndL();
            }
        }
        return theVar;
    }

    public List<CSVData> parseCSV(InputData inputData) throws IOException {
        BufferedReader csvReader = null;
        List<CSVData> csvData = new ArrayList<>();

        try {
            csvReader = new BufferedReader(new FileReader(inputData.getCsvPath()));
            String row;
            int csvIterator = 0;
            while ((row = csvReader.readLine()) != null) {
                csvIterator ++;
                String[] data = row.split(";");
                try {
                    Date csvDate = VarUtils.parseDateYYYYMMDD((data[0]));
                    Date dateMinusHistoricalDept = VarUtils.getXdaysBefore(inputData.getCurrentDate(), inputData.getHistoricalDept());

                    if(csvDate.compareTo(inputData.getCurrentDate()) <=0 && csvDate.compareTo(dateMinusHistoricalDept) >= 0){ // csvDate is before currentDate
                        BigDecimal amount =  VarUtils.parseCurrency(data[1]);
                        csvData.add(new CSVData(csvDate, amount.doubleValue()) );
                    }
                } catch (Exception e){
                    System.err.println("Erreur in line : " + csvIterator);
                }
            }
        } catch (Exception e){
            System.err.println("We are having problems reading the file");
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
        }
        return csvData;

    }




}
