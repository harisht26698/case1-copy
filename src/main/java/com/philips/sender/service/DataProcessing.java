package com.philips.sender.service;

public class DataProcessing {
    public static String[] csvLineToArrayOfString(String line) {
        String[] lineData = line.split(",");
        return lineData;
    }
    public static int getColumnNumber(String[] lineData, String coloumnName){
        int cnt=0;
        for (String col : lineData) {
            if (coloumnName.equals(col))
                break;
            cnt++;
        }
        if(lineData.length == cnt)
            return -1;
        return cnt;
    }
}
