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
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvFormat;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;


public class csvreader {
    private static final Logger log = LoggerFactory.make();
    private final List<String> headers = new ArrayList<>();
    private final static List<List<String>> values = new ArrayList<>();

/**
 *  datafIle - To read the .csv file and retrieve data
 *  IOException - To resolve errors 
 * 
 * @param dataFile
 * @throws IOException
 * @return 
 */

public String read(File dataFile) throws IOException {
    if(FIlenameUtils.getExtension(datafile.getName()).equalsIgnoreCase("csv")) {
        readCSVFile(dataFile);
    } else {
            return ("Process Invalid");
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

    public static <CSVFormat, CSVRecord, CSVParser> void readCSVFile(File csvfile, Object NUMERIC) throws IOException {
        try (Reader reader = new FileReader(csvfile)) {
            CSVFormat strategy = CSVFormat.DEFAULT.
                withHeader().
                withDelimiter(',').
                withQuote('"').
                withCommentMarker((char)0).
                withIgnoreEmptyLines().
                withIgnoreSurroundingSpaces();

            CsvParser parser = new CsvParser(reader, strategy)) {
                Map<String, Integer> headerMap = parser.getHeaderMap();
                for(Map.Entry<String, Integer entry : headerMap.entryset()) {
                    headers.add(entry.getKey());
                    log.info("Had header '" + entry.getKey() + "' for column " + entry.getValue());
                }
            
            List<CSVRecord> lines = parser.getRecords();
            log.info("Found " + lines.size() + " lines");
            for(CSVRecord line : lines) {
                List<String> data = new ArrayList<>();
                for(int pos = 0;pos < headerMap.size();pos++) {
                        if(line.size() <= pos) {
                            data.add(null);
                        } else {
                            data.add(line.get(pos));
                        }
                    }

                    values.add(data);

                    start = row.getFirstCellNum();
                end = row.getLastCellNum();
                for(int cellNum = start;cellNum <= end;cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if(cell == null) {
                        // add null to the headers if there are columns without title in the sheet
                        headers.add(null);
                        log.info("Had empty header for column " + CellReference.convertNumToColString(cellNum));
                    } else {
                        String value = cell.toString();
                        headers.add(value);
                        log.info("Had header '" + value + "' for column " + CellReference.convertNumToColString(cellNum));
                    }
                }
            }

            for(int rowNum = 1; rowNum <= sheet.getLastRowNum();rowNum++) {
                Row row = sheet.getRow(rowNum);
                if(row == null) {
                    // ignore missing rows
                    continue;
                }

                List<String> data = new ArrayList<>();
                for(int colNum = start;colNum <= end;colNum++) {
                    Cell cell = row.getCell(colNum);
                    if(cell == null) {
                        // store null-data for empty/missing cells
                        data.add(null);
                    } else {
                        final String value;
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                break;
                            default:
                            value = cell.toString();
                        }

                        data.add(value);
                    }
                }

                values.add(data);
            
        
    }

    /**
     * Return a list of rows containing the data-values.
     *
     * @return a list of rows, each containing a list of data-values as strings.
     */
    public List<List<String>> getData() {
        return values;
    }

    /**
     * A list of header-names that are used to replace the templates.
     *
     * @return The header-names as found in the .csv/.xls/.xlsx file.
     */
    public List<String> getHeaders() {
        return headers;
    }
}
