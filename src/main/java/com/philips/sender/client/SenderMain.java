package com.philips.sender.client;

import com.philips.sender.service.FileHandler;
import com.philips.sender.service.FileNameReader;
import com.philips.sender.service.PrintToConsole;

import java.io.BufferedReader;
import java.io.IOException;

public class SenderMain {
    public static void main(String[] args) throws IOException {
        String filePath = FileNameReader.csvFileNameReaderFromConsol();
        BufferedReader br = FileHandler.invokesWithFilePathThenReturnsBufferedReader(filePath);
        if(args.length==0)
            PrintToConsole.bufferDataIsPrintingToConsole(br);
        else
            PrintToConsole.specificColumnOfBufferDataPrintedToConsole(br,args[0]);
    }
}
