package com.philips.sender.service;

public class DataProcessing {
    public static String[] csvLineToArrayOfString(String line) {
        String[] lineData = line.split(",");
        return lineData;
    }
    public static int getColumnNumber(String[] lineData, String columnName){
        int cnt=0;
        for (String col : lineData) {
            if (columnName.equals(col))
                break;
            cnt++;
        }
        return validateColumnNumber(lineData.length,cnt);
    }
    public static int validateColumnNumber(int length,int cNum){
        if(length <= cNum)
            return -1;
        return cNum;
    }
}
