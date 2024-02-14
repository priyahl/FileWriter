package com.fileExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fileExample.service.FileReaderService;
@RestController
public class FileReaderExample {
	  @Autowired
	    private FileReaderService fileReaderService;
	  
	  @PostMapping("/processFile")
	    public void processFile() {
	        // Define the source and destination file paths and the pattern to search for
	        String sourceFilePath = "C:\\Users\\diksha\\Desktop\\work\\18\\titan-umarket-server.2023-10-12.0.log";
	        String destinationFilePath = "C:\\Users\\diksha\\Desktop\\1stError.txt";
	        String pattern = "ERROR";

	        // Process the file and write the lines containing the specified pattern to the new file
	        fileReaderService.processAndWriteToFile(sourceFilePath, destinationFilePath, pattern);
	    }
	  

}
