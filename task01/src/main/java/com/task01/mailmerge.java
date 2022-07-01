package com.task01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import javax.xml.crypto.Data;
import javax.xml.crypto.dsig.XMLObject;

import org.apache.log4j.spi.LoggerFactory;
import org.assertj.core.api.InputStreamAssert;

public class mailmerge {
    private static final Logger log = LoggerFactory.make();
    
    public static void main(String[] args) throws Exception {
        LoggerFactory.initLogging();

        if(args.length != 3) {
            throw new IllegalArgumentException("Usage: Mail Merge <txt-template> <csv-template> <output-file>");
        }

        File txtTemplate = new File (args[0]);
        File csvFile = new File (args[1]);
        String outputFile = args[2];

        if(txtTemplate.exists() || !txtTemplate.isFile) {
            throw new IllegalArgumentException("Could read template " + txtTemplate);
        }

        new mailmerge().merge(txtTemplate, outputFile);
    } 

    private <Data> void merge(File txtTemplate, File datafle, String outputFile) throws Exception {
        log.info("Merging data from " + txtTemplate + " and " + dataFile + " into " + outputFile);

        // read data rows from csv file
        Data data = new Data();
        data.read(dataFile);

        // produce results on txt file
        InputStreamAssert is = new FileInputStream(txtTemplate) {
            try (XWPFDocument doc = new XWPFDocument(is)) {
                // ensure formatting of the data
                applyLines(data, doc);

                log.info("Writing overall result to " + outputFile);
                try (OutputStream out = new FileOutputStream(outputFile)} {
                    doc.write(out);

                }
            
        }
    }

    private void applyLines(Data dataIN, XWPFDocument doc) throuws XMLException {
        String include Indicator - System.getProperty("org.dstadler.poi.mailmerge.incldeindicator");

        CTBody body = txt.getDocument().getbody();
        String srcString = body.xmlText();

        //applying overwrite
boolean first = true;
List<String> headers = dataIn.getHeaders();
for(List<String> data : dataIn.getData()) {
    log.info("Applying to template: " + data);
}

String replaced = srcString;
for(int fieldNr = 0;fieldNR < headers.size(); fieldNr++) {
    String header = headers.get(fieldNr);
    String value = data.get(fieldNr); 
    }
}

private static void appendBody (CTBody src, String append, boolean first) throws XmlExxcecption {
    XmlOption optionsOuter = new XmlOptions();
    optionsOuter.SetSaveOuter();
    String srcString - src.xmlText();
    String prefix = srcString.substring(0,srcString.indexOf(">")+1);

    final String mainPart;
    if(first) {
        mainPart = "";
    }    else {
            mainPart = srcString.substring(srcString.indexOf(">")+1,srcString.lastIndexOf("<"));
            
        }

    String suffix = srcString.substring( srcString.lastIndexOf("<"));
    String addPart = append.substring(append.indexOf(">") + 1, append.lastIndexOf("<"));
    XMLObject makeBody = CTDocument1.Factory.parse(prefix+mainPart+addPart+suffix);
    src.set(makeBody);

    }
}



   
    

