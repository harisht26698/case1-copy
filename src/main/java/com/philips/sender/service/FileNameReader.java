package com.philips.sender.service;

import java.util.Scanner;

public class FileNameReader {
    public static String csvFileNameReaderFromConsol(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input CSV file path : ");
        String filePath = scan.next();
        return filePath;
    }
}
