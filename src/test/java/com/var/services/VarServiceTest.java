package com.var.services;

import com.var.domaine.CSVData;
import com.var.domaine.InputData;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class VarServiceTest {

    private VarService varService = new VarService();
    private static final  Date currentDate = new GregorianCalendar(2019, Calendar.JANUARY, 01).getTime();
    private static final InputData inputData = new InputData(currentDate, 365, 95, "/home/yassine/Téléchargements/HISTORICAL_PnL_2.csv");


    @Test
    public void getTheVarForACertainPercentile() {
        List<CSVData> csvData = new ArrayList<>();
        Date dateInCsv =  new GregorianCalendar(2018, Calendar.JANUARY, 01).getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateInCsv);

        for (int i = 0; i< 12; i++){
            csvData.add(new CSVData(calendar.getTime(), 150.00 + i*90));
            calendar.add(Calendar.MONTH, 1);
        }

        csvData.forEach((e) -> { System.out.println(e.toString()); });

        assertEquals(240, varService.getTheVarForACertainPercentile(csvData, inputData), 5);
    }

    @Test
    public void parseCSV() throws IOException {

        List<CSVData> csvData = new ArrayList<>();
        Date dateInCsv =  new GregorianCalendar(2018, Calendar.JANUARY, 01).getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateInCsv);
        for (int i = 0; i< 3; i++){
            csvData.add(new CSVData(calendar.getTime(), 150.00 + i*10));
            calendar.add(Calendar.MONTH, 1);
        }

        csvData.forEach((e) -> { System.out.println(e.toString()); });

        assertEquals(csvData, varService.parseCSV(inputData));
        assertThat(csvData, is(varService.parseCSV(inputData)));
    }
}
