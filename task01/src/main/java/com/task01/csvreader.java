package com.task01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.lf5.util.StreamUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;


public class csvreader {
    private static final Logger log = LoggerFactory.make();
    private final List<String> headers = new ArrayList<>();
    private final List<List<String>> values = new ArrayList<>();

/**
 *  datafIle - To read the .csv file and retrieve data
 *  IOException - To resolve errors 
 */

public void read(File dataFile) throuws IOException {
    if(FIlenameUtils.getExtension(datafile.getName()).equalsIgnoreCase("csv")) {
        readCSVFile(dataFile);
    } else {
            return;
    }
    removeEmptyLines();
}

public void removeEmptyLines () {
Iterator<List<String>> it = values.iterator();
while(it.hasNext()) {
    List<String> line = it.next ();
    boolean empty = true;
    for(String item : line) {
        if(StreamUtils.isNotBlank(item)) {
            empty = false;
            break;

        }
    }
    // to remove empty line
    if(empty) {
        log.info("Removing an empty data line");
        it.remove ();
    }

}

} 

    public static <CSVFormat> void readCSVFile(File csvfile) throws IOException {
        try (Reader reader = new FileReader(csvfile)) {
            CSVFormat strategy = CSVFormat.DEFAULT.
                withHeader().
                withDelimiter(',').
                withQuote('"').
                withCommentMarker((char)0).
                withIgnoreEmptyLines().
                withIgnoreSurroundingSpaces();

            try (CSVParser parser = new CsvParser(reader, strategy)) {
                Map<String, Integer> headerMap = parser.getHeaderMap();
                for(Map.Entry<String, Integer entry : headerMap.entryset()) {
                    headers.add(entry.getKey());
                    log.info("Had header '" + entry.getKey() + "' for column " + entry.getValue());
                }















            }
        }
    }