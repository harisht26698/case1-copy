package com.philips.receiver.service;

import java.io.IOException;

public class Validation {
    public static String date="";
    public static int flag=0;
  public static void validateDataThenSendValidDataToStore(String[] words) throws IOException {
      if(isArrayEmpty(words))
          return;
      if(ProcessingData.isDate(words[0])) {
          newComment(words);
      }
      else {
          oldComment(words);
      }
    }
    public static void newComment(String[] words){
        date=words[0];
        for (int i = 2; i < words.length; i++) {
            if(!ProcessingData.isNumber(words[i]))
            DataStorage.storeDataInMap(words[i], date);
        }
    }
    public static void oldComment(String[] words){
        for (int i = 0; i < words.length; i++) {
            if(!ProcessingData.isNumber(words[i]))
            DataStorage.storeDataInMap(words[i], date);
        }
    }
    public static boolean isArrayEmpty(String[] words){
      if(words.length==0)
          return true;
      return false;
    }
  }
