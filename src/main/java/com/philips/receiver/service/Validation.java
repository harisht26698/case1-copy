package com.philips.receiver.service;

import com.philips.receiver.service.ProcessingData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validation {
  public static void dataValidation(String wordCount, String wordWithDate, String line, String date){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (!line.equals("done")) 
    {
        if(line.equals("")){
          line=br.readLine();
          continue;
      }

      line= ProcessingData.filteringLine(line);
      String[] words=line.split(" ");
      int flag=0;
      for(String word:words) {
          if(flag==0){
              if(ProcessingData.isDate(word)){
                  flag++;
                  date=word;
                  continue;
              }
              else
              {
                  flag=2;
              }
          }
          if(flag==1){
              flag++;
              continue;
          }
          if(ProcessingData.isNumber(word))
              continue;
          DataStorage.wordsCount(wordCount, wordWithDate, word, date);
      }
    }
}