package com.philips.sender.service;

import java.io.BufferedReader;
import java.io.IOException;

public class PrintToConsole {
    private static String line = "";
    private static String[] lineData;
    private static int columnNumber=0;

    public static void bufferDataIsPrintingToConsole(BufferedReader br) throws IOException {
        while ((line = br.readLine()) != null) {
            lineData = DataProcessing.csvLineToArrayOfString(line);
            printingArrayOfStringToConsole();
        }
        System.out.println("done");
    }

    public static void specificColumnOfBufferDataPrintedToConsole(BufferedReader br, String columnName) throws IOException {
        line=br.readLine();
        lineData = DataProcessing.csvLineToArrayOfString(line);
        columnNumber = DataProcessing.getColumnNumber(lineData,columnName);
        if(!isColumnExists(columnNumber)){
            return;
        }
        while ((line = br.readLine()) != null) {
            lineData = DataProcessing.csvLineToArrayOfString(line);
            printingSpecificStringOfArray();
        }
        System.out.println("done");
    }

    public static void printingArrayOfStringToConsole(){
        for (String word : lineData) {
            System.out.print(word + "  ");
        }
        System.out.println();
    }

    public static void printingSpecificStringOfArray(){
        if(lineData.length >columnNumber)
            System.out.println(lineData[columnNumber]);
    }

    public static boolean isColumnExists(int cNumber){
        if(cNumber == -1) {
            System.out.println("Column not exist");
            return false;
        }
        return true;
    }
}
