package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    public void readFromFile() {
        Path path = Paths.get("src/main/resources/AddressBook.txt");

        try {
            System.out.println(Files.readAllLines(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void writeIntoFile(String adBookName, AddressBookService adBookHandler) {

        AddressBook adBook = adBookHandler.findAddressBook(adBookName);
        Path path = Paths.get("src/main/resources/AddressBook.txt");

        try {
            Files.write(path, adBook.addressBook.toString().getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

