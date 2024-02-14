package com.fileExample.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FileReaderService {

	public void processAndWriteToFile(String sourceFilePath, String destinationFilePath, String pattern) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            boolean foundPattern = false;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the specified pattern
                if (line.contains(pattern)) {
                    foundPattern = true;
                    String[] words = line.split(" ");
                    writer.write(
                    "Time : "+words[0]+"\n"
                    +"UserId : "+words[3]+"\n"
                    +"URL : "+words[4]+"\n"
                    +"Error : "+reader.readLine()+"\n"
                    +reader.readLine()+"\n"+"\n");
                }
            }
            if (!foundPattern) {
                throw new RuntimeException("Pattern '" + pattern + "' not found in the file.");
            }
       } catch (IOException e) {
            e.printStackTrace(); 
        }
        }
	   

}
