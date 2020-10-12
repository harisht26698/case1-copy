package com.philips.sender.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrintToConsole {
    private static String line = "";
    public static String[] lineData;
    private static int columnNumber=0;
    public static FileWriter csvWriter;
    static {
        try {
            csvWriter = new FileWriter("console.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void printingArrayOfStringToConsole() throws IOException {
        for (String word : lineData) {
            consoleOutput(word + " ");
        }
        System.out.println();
    }

    public static void printingSpecificStringOfArray() throws IOException {
        if(lineData.length >columnNumber)
            consoleOutput(lineData[columnNumber]);
        System.out.println();
    }

    public static boolean isColumnExists(int cNumber){
        if(cNumber == -1) {
            System.out.println("Column not exist");
            return false;
        }
        return true;
    }
    public static void consoleOutput(String str) throws IOException {
        System.out.print(str);
        csvWriter.append(str);
        csvWriter.flush();
    }
}
