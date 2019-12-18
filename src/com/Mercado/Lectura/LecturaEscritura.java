package com.Mercado.Lectura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {

        try {
            //Create a instance of File class by specifying the existing file name with path
            File file = new File("d:/sampleFileNew.txt");

            //Create a instance of BufferedWriter Class to write data to the file
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Data in the File: AAA BBB CCC DDD\n");
            bw.close();

            //Create a instance of BufferedReader Class to read data from file
            BufferedReader in = new BufferedReader(new FileReader(file));
            String dataInFile;
            while ((dataInFile = in.readLine()) != null) {
                System.out.println(dataInFile);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("IOException :"+ e);
        }
    }
}

