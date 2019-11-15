package com.var;

import com.var.domaine.CSVData;
import com.var.domaine.InputData;
import com.var.services.*;
import com.var.utils.VarUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        InputData inputData = new InputData();
        VarService varService = new VarService();


        if (args.length > 3) {
            if(VarUtils.isValidFormat("yyyy-MM-dd", args[0])){
                inputData.setCurrentDate(VarUtils.parseDateYYYYMMDD(args[0]));
            } else {
                System.err.println("Argument" + args[0] + " must be of a YYYY-MM-DD format");
            }

            try {
                inputData.setHistoricalDept(Integer.parseInt(args[1]));
                inputData.setPercentileCoefficient(Integer.parseInt(args[2]));
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " or " + args[2] + " must be an integer.");
            }
            inputData.setCsvPath(args[3]);
        }

        List<CSVData> csvData =  varService.parseCSV(inputData);
        double theVar = varService.getTheVarForACertainPercentile(csvData,inputData);


        csvData.forEach((e) -> { System.out.println(e.toString()); });


        System.out.println("VaR" + inputData.getPercentileCoefficient() +  " for "+ inputData.getHistoricalDept() +" days  = " + theVar);

    }


}
