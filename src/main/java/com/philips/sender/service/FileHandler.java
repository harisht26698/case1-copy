package com.philips.sender.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandler {
    public static BufferedReader invokesWithFilePathThenReturnsBufferedReader(String filePath) throws FileNotFoundException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(filePath));
        return br;
    }
}
