package com.philips.receiver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public static void readsDataFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String colNames = br.readLine();
            String line=br.readLine();

            while (!isEnd(line)) {
                if(isEmptyLine(line)){
                    line=br.readLine();
                    continue;
                }
                line=ProcessingData.filteringLine(line);
                String[] words=line.split(" ");
                Validation.validateDataThenSendValidDataToStore(words);
                line = br.readLine();
            }

    }

    public static boolean isEnd(String line){
        return line.equals("done");
    }

    public static boolean isEmptyLine(String line){
        return line.equals("");
    }
}
