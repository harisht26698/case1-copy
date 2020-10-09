package com.philips.receiver.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataStorage {
    public static Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
    public static Map<String, String> wordWithDate = new LinkedHashMap<String, String>();

  public static void storeDataInMap(String word, String date){
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