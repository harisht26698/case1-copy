package com.philips.receiver.service;

import java.io.IOException;

public class Validation {
    public static String date="";
    public static int flag=0;
  public static void validateDataThenSendValidDataToStore(String[] words) throws IOException {
      flag=0;
      for(String word:words) {
          if(isSkipable(word)){
              continue;
          }
          DataStorage.storeDataInMap(word,date);
      }
    }
    public static boolean isDateAndTimeOfComment(String word){
        if(ProcessingData.isDate(word)){
            flag++;
            date=word;
            return true;
        }
            flag=2;
        return false;
    }
    public static boolean checkWordToSkip(String word){
        if(flag==0){
            return isDateAndTimeOfComment(word);
        }
        if(flag==1){
            flag++;
            return true;
        }
      return false;
    }
    public static boolean isSkipable(String word){
        if(checkWordToSkip(word)||ProcessingData.isNumber(word)){
            return true;
        }
        return false;
    }
  }
