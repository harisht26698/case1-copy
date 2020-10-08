package com.philips.receiver.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataStorage {
  public static void wordsCount(String wordCount, String wordWithDate, String word, String date){
    if (wordCount.containsKey(word)) {
      wordCount.put(word, wordCount.get(word) + 1);
      wordWithDate.put(word,wordWithDate.get(word)+" " +date);
  }
  else {
      wordCount.put(word, 1);
      wordWithDate.put(word, date);
  }

  }
}