package com.philips.receiver.service;

import com.philips.receiver.service.Validation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleReader {
  public static Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
  public static Map<String, String> wordWithDate = new LinkedHashMap<String, String>();
  
  public static void readDataFromConsole(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
          String colNames = br.readLine();
          String line=br.readLine();
          String date="";
          
          Validation.dataValidation(wordCount, wordWithDate, line, date);
          line = br.readLine();
        }
    catch (IOException e) 
        {
          e.printStackTrace();
        }
      }
}