package com.philips.receiver.server;

import com.philips.receiver.service.ConsoleReader;
import com.philips.receiver.service.WriteToCSV;
import java.io.IOException;


public class ReceiverMain {
  public static void main(String[] args) throws IOException {
    ConsoleReader.readsDataFromConsole();
    WriteToCSV.mapToCsvWriter();
  }
}
